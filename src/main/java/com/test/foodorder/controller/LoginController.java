package com.test.foodorder.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.foodorder.exception.AuthorizationException;
import com.test.foodorder.model.LogInModel;
import com.test.foodorder.service.impl.LogInModelServiceImpl;



@RestController
public class LoginController {
	
	@Autowired
	private LogInModelServiceImpl loginService;
	
	@PostMapping("/login")
	public String loginHandler(@RequestBody LogInModel loginData) throws AuthorizationException {
		return loginService.LogIn(loginData);
	}
	
	

}
