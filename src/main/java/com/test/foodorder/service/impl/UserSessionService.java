package com.test.foodorder.service.impl;

import com.test.foodorder.exception.AuthorizationException;
import com.test.foodorder.model.LogInModel;
import com.test.foodorder.model.SignUpModel;
import com.test.foodorder.model.UserSession;

public interface UserSessionService {
	
	public UserSession getUserSession(String key) throws AuthorizationException;
	
	public Integer getUserSessionId(String key) throws AuthorizationException;
	
	public SignUpModel getSignUpDetails(String key) throws AuthorizationException;
	

}
