package com.test.foodorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.foodorder.model.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer>
{

	 List<Items> findByCategoryId(Long postId);
}



