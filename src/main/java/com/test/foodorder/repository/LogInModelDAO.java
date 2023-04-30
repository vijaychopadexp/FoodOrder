package com.test.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.foodorder.model.LogInModel;




@Repository
public interface LogInModelDAO extends JpaRepository<LogInModel, Integer>{
	
	

}
