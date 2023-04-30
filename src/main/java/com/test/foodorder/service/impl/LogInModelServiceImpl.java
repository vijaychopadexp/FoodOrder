package com.test.foodorder.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.foodorder.exception.AuthorizationException;
import com.test.foodorder.model.LogInModel;
import com.test.foodorder.model.SignUpModel;

import com.test.foodorder.model.UserSession;
import com.test.foodorder.repository.LogInModelDAO;
import com.test.foodorder.repository.SignUpModelDAO;
import com.test.foodorder.repository.UserSessionDAO;
import com.test.foodorder.service.RandomString;



@Service
public class LogInModelServiceImpl implements LogInModelService {
	

	@Autowired
	private SignUpModelDAO signUpDAO;
	
	@Autowired
	private UserSessionDAO userSessionDAO;
	
	@Autowired
	private UserSessionService userLogInSession;
	
	@Autowired
	private LogInModelDAO loginDataDAO;
	
	@Override
	public String LogIn(LogInModel loginData) throws AuthorizationException {
		
		Optional<SignUpModel> opt = signUpDAO.findById(loginData.getUserId());
		
		if(!opt.isPresent())
		{
			throw new AuthorizationException("Invalid Login UserId");
		}
		
		SignUpModel newSignUp = opt.get();
		
		Integer newSignUpId = newSignUp.getUserId();
		Optional<UserSession> currentUserOptional = userSessionDAO.findByUserId(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			throw new AuthorizationException("User Already LoggedIn with this UserId");
		}
		
		if((newSignUp.getUserId() == loginData.getUserId()) && (newSignUp.getPassword().equals(loginData.getPassword())))
		{
			String key = RandomString.getRandomString();
			
			UserSession currentUserSession = new UserSession(newSignUp.getUserId(),key,LocalDateTime.now());
			userSessionDAO.save(currentUserSession);
			loginDataDAO.save(loginData);
			
			return currentUserSession.toString();
			
		}
		else
			throw new AuthorizationException("Invalid UserName or Password..");
			
			
		
	}



}
