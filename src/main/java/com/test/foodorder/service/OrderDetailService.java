package com.test.foodorder.service;

import java.util.List;

import com.test.foodorder.exception.OrderException;
import com.test.foodorder.model.FoodOrder;
import com.test.foodorder.model.Items;


public interface OrderDetailService {
	
	public FoodOrder addOrder(FoodOrder order)throws OrderException;
	
	public FoodOrder updateOrder(FoodOrder order)throws OrderException;
	
	
	public FoodOrder viewOrder(Integer orderId)throws OrderException;
	
	public List<Items> viewAllOrdersByCustomer(Integer customerId)throws OrderException;

}
