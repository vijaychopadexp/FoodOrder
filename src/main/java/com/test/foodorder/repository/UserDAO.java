package com.test.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.foodorder.model.Users;



public interface UserDAO extends JpaRepository<Users, Integer>{

}
