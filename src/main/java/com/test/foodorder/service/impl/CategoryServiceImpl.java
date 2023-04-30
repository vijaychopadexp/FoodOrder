package com.test.foodorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.foodorder.model.Category;
import com.test.foodorder.model.Items;
import com.test.foodorder.repository.CategoryRepository;
import com.test.foodorder.repository.ItemsRepository;
import com.test.foodorder.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@Autowired
	ItemsRepository itemRepository;
	
	
	//get Category list
	public List<Category> findAll() {

	return categoryRepository.findAll();

	}

	public  List<Items> findByCategoryId(Long categoryID ) 
	 {
		return itemRepository.findByCategoryId(categoryID);
		 
	 }
	 
	
	
	
}
