package com.test.foodorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.foodorder.exception.AuthorizationException;
import com.test.foodorder.exception.OrderException;
import com.test.foodorder.model.FoodOrder;
import com.test.foodorder.model.Items;
import com.test.foodorder.service.OrderDetailService;
import com.test.foodorder.service.impl.UserSessionService;


@RestController
@RequestMapping("/order")
public class OrderDetailServiceController {
	
	@Autowired
	OrderDetailService orderService;
	
	@Autowired
	UserSessionService userSessionService;
	
	
	
	 @PostMapping("/save")
     public ResponseEntity<FoodOrder> saveOrder(@RequestBody FoodOrder order, @RequestParam String key) throws OrderException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return new ResponseEntity<FoodOrder>(orderService.addOrder(order), HttpStatus.CREATED);
     	else
     		throw new OrderException();
     }
	 
	 
	 @PutMapping("/update")
     public ResponseEntity<FoodOrder> updateOrder(@RequestBody FoodOrder order, @RequestParam String key) throws OrderException, AuthorizationException{
         
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return new ResponseEntity<FoodOrder>(orderService.updateOrder(order), HttpStatus.ACCEPTED);
     	else
     		throw new OrderException();
     		
     }
	 

	 
	 @GetMapping("/view/{orderId}")
     public ResponseEntity<FoodOrder> viewOrder(@PathVariable("orderId") Integer orderId,@RequestParam String key) throws OrderException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return  new ResponseEntity<FoodOrder>(orderService.viewOrder(orderId),HttpStatus.FOUND);
     	else
     		throw new OrderException();
     }
	 
	 
	 @GetMapping("/viewbycustomer/{customerId}")
     public ResponseEntity<List<Items>> viewAllOrders(@PathVariable("customerId") Integer customerId,@RequestParam String key) throws OrderException, AuthorizationException{
     	
     	Integer sessionId = userSessionService.getUserSessionId(key);
     	
     	if(sessionId != null)
     		return  new ResponseEntity<List<Items>>(orderService.viewAllOrdersByCustomer(customerId), HttpStatus.FOUND);
     	else
     		throw new OrderException();
     }

}
