package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstratcs.FieldService;
import com.hrms.hrms.business.abstratcs.JobPositionService;
import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	private FieldService<JobPosition> controllerService;
	
	public JobPositionManager(FieldService<JobPosition> controllerService) {
		super();
		this.controllerService = controllerService;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return controllerService.getAll();
	}

	@Override
	public Result add(JobPosition newJobPositions) {
		
		return controllerService.verifyData(newJobPositions);
	}

}
