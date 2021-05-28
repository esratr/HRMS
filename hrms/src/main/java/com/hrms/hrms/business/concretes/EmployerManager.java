package com.hrms.hrms.business.concretes;

import java.util.List;

import com.hrms.hrms.business.abstratcs.EmployerService;
import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.core.utilities.result.SuccessDataResult;
import com.hrms.hrms.core.utilities.result.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.Employer;

public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"İş verenler listelendi.");
	}
	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		
		return new SuccessResult("İş veren eklendi");
	}

}
