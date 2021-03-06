package com.hrms.hrms.business.required;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.hrms.business.abstratcs.FieldService;
import com.hrms.hrms.business.abstratcs.VerifyCodeService;
import com.hrms.hrms.core.utilities.adapters.MernisServiceDemo;
import com.hrms.hrms.core.utilities.adapters.VerifyApiService;
import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.ErrorResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.core.utilities.result.SuccessDataResult;
import com.hrms.hrms.core.utilities.result.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.dataAccess.abstracts.UserDao;
import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class CandidateFieldManager implements FieldService<Candidate> {

	@Autowired
	private CandidateDao candidatesDao;
	private UserDao userDao;
	private MernisServiceDemo mernisServis;
	private VerifyCodeService verifyCodeService;



	public CandidateFieldManager(CandidateDao candidatesDao, UserDao userDao, MernisServiceDemo mernisServis,
			VerifyCodeService verifyCodeService) {
		super();
		this.candidatesDao = candidatesDao;
		this.userDao = userDao;
		this.mernisServis = mernisServis;
		this.verifyCodeService = verifyCodeService;
	}

	@Override
	public Result verifyData(Candidate candidate) {
		if (!this.mernisServis.checkIfRealPerson(candidate)) {
			return new ErrorResult("Yanlış kimlik doğrulaması yapıldı.");
		}
		if (this.userDao.existsByMail(candidate.getMail())) {
			return new ErrorResult("Mail adresi daha önce kullanıldı");
		}
		if (candidatesDao.existsByNationalIdentity(candidate.getNationalIdentity())) {
			return new ErrorResult("TC kimlik numarası daha önce kullanıldı");
		}
		if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("Şifreler uyuşmuyor.");
		}
		this.candidatesDao.save(candidate);
		this.verifyCodeService.createVerifyCode(userDao.getOne(candidate.getId()));
		this.verifyCodeService.sendMail(candidate.getMail());

		return new SuccessResult("Kayıt Başarılı!");

	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidatesDao.findAll(), "Listeleme Başarılı!");
	}
}
