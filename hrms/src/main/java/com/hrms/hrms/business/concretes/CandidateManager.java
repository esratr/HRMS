package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;


import com.hrms.hrms.business.abstratcs.CandidateService;
import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.core.utilities.result.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.entities.concretes.Candidate;

import com.hrms.hrms.core.utilities.result.*;


@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;

	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"İş arayanlar listelendi.");
}

	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("iş arayan eklendi.");
	}

	
}

