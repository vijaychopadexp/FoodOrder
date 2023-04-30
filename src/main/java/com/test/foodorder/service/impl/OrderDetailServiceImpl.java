package com.test.foodorder.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.foodorder.exception.OrderException;
import com.test.foodorder.model.FoodOrder;
import com.test.foodorder.model.Items;
import com.test.foodorder.model.Users;
import com.test.foodorder.repository.OrderDAO;
import com.test.foodorder.repository.UserDAO;
import com.test.foodorder.service.OrderDetailService;


@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	UserDAO cusDAO;

	
	
	public FoodOrder addOrder(FoodOrder order) throws OrderException {
		Optional<FoodOrder> opt = orderDAO.findById(order.getId());
		if(opt.isPresent()) {
			throw new OrderException("Order already exists..");
		}else {
			return orderDAO.save(order);
		}
	}



	
	public FoodOrder updateOrder(FoodOrder order) throws OrderException {
		Optional<FoodOrder> opt = orderDAO.findById(order.getId());
		if(opt.isPresent()) {
			return orderDAO.save(order);
		}else {
			throw new OrderException("Order such Order exists..");
		}
	}






	public FoodOrder viewOrder(Integer orderId) throws OrderException {
		Optional<FoodOrder> opt = orderDAO.findById(orderId);
		if(opt.isPresent()) {
			FoodOrder order = opt.get();
			return order;
		}else {
			throw new OrderException("No Order found with ID: "+orderId);
		}
	}



	
	public List<Items> viewAllOrdersByCustomer(Integer customerId) throws OrderException{
		Optional<Users> cOpt =cusDAO.findById(customerId);
		if(cOpt.isPresent()) {
			Users customer = cOpt.get();
			 List<Items> itemList = customer.getFoodbasket().getItemList();
			 if(itemList.size() > 0) {
				 return itemList;
			 }else {
				 throw new OrderException("No Orders found..");
			 }
		}else {
			
		}
		return null;
	}

}
