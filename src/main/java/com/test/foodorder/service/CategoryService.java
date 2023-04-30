package com.test.foodorder.service;

import java.util.List;

import com.test.foodorder.model.Category;
import com.test.foodorder.model.Items;

public interface CategoryService {
	 List<Category> findAll() ;
	 
	 List<Items> findByCategoryId(Long categoryID) ;
	 
}
