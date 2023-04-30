package com.test.foodorder.service.impl;

import com.test.foodorder.exception.AuthorizationException;
import com.test.foodorder.model.LogInModel;

public interface LogInModelService {
	
	public String LogIn(LogInModel login) throws AuthorizationException;
	
	

}
