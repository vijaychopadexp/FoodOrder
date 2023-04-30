package com.test.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.test.foodorder.model.FoodOrder;


@Repository
public interface OrderDAO extends JpaRepository<FoodOrder, Integer>{

}
