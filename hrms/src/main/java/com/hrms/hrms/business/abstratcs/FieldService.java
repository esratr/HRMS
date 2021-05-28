package com.hrms.hrms.business.abstratcs;

import java.util.List;

import com.hrms.hrms.core.utilities.result.DataResult;
import com.hrms.hrms.core.utilities.result.Result;

public interface FieldService<T> {
	
	Result verifyData(T data);

	DataResult<List<T>> getAll();

}
