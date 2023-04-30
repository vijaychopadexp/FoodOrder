package com.test.foodorder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.foodorder.model.Category;
import com.test.foodorder.model.Items;
import com.test.foodorder.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategory() {
System.out.println("Changed code 30april 23" );
		List<Category> list = categoryService.findAll();
		// Optional<Category> category = categoryService.findAll();
		System.out.println("category List:" + list);
		// return new ResponseEntity(list, HttpStatus.OK);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/category/{categoryID}/items")
	public ResponseEntity<List<Items>> getAllItemsByCategoryId(@PathVariable(value = "categoryID") Long categoryID) {
		System.out.println("Changed code 30april 23 8PM" );
		List<Items> list = categoryService.findByCategoryId(categoryID);
		return ResponseEntity.ok().body(list);
	}

}
