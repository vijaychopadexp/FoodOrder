package com.test.foodorder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.foodorder.model.SignUpModel;



@Repository
public interface SignUpModelDAO extends JpaRepository<SignUpModel, Integer> {
	
	public Optional<SignUpModel> findByUserName(String userName);

}
