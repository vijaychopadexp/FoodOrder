package com.test.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.foodorder.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
