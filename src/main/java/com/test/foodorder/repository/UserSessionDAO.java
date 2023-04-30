package com.test.foodorder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.foodorder.model.UserSession;




@Repository
public interface UserSessionDAO extends JpaRepository<UserSession, Integer> {
	
	public Optional<UserSession> findByUserId(Integer userId);
	
	public Optional<UserSession> findByUUID(String uuid);

}
