package com.hrms.hrms.business.abstratcs;

import com.hrms.hrms.core.utilities.result.Result;
import com.hrms.hrms.entities.concretes.User;

public interface VerifyCodeService {
	String createVerifyCode(User user);
	void sendMail(String mail);
	Result verifyUser(String code); 

}
