package com.hrms.hrms.business.abstratcs;

import java.util.List;

import com.hrms.hrms.core.utilities.result.*;
import com.hrms.hrms.entities.concretes.Employer;



public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
