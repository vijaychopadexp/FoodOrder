package com.test.foodorder.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.foodorder.exception.CartException;
import com.test.foodorder.exception.ItemException;
import com.test.foodorder.model.FoodBasket;
import com.test.foodorder.model.Items;
import com.test.foodorder.repository.FoodBasketDAO;
import com.test.foodorder.repository.ItemsRepository;
import com.test.foodorder.service.FoodBasketService;


@Service
public class FoodBasketServiceImpl implements FoodBasketService{
	
	@Autowired
	FoodBasketDAO cartDAO;

	@Autowired
	ItemsRepository itemDAO;
	
	
	@Override
	public FoodBasket saveCart(FoodBasket cart) throws CartException {
		Optional<FoodBasket> opt = cartDAO.findById(cart.getId());
		if(opt.isPresent()) {
			throw new CartException("Cart already exists..");
		}else {
			 return cartDAO.save(cart);
		}
	}





	@Override
	public FoodBasket viewCart(Integer cartId) throws CartException {
		Optional<FoodBasket> opt = cartDAO.findById(cartId);
		if(opt.isPresent()) {
			FoodBasket cart = opt.get();
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}


	@Override
	public FoodBasket addItem(Integer cartId, Integer itemId) throws CartException, ItemException {
		Optional<FoodBasket> cOpt = cartDAO.findById(cartId);
		if(cOpt.isPresent()) {
			
			Optional<Items> iOpt = itemDAO.findById(itemId);
			if(iOpt.isPresent()) {
				
				FoodBasket cart = cOpt.get();
				Items item = iOpt.get();
				List<Items> list = new ArrayList<>();
				list.addAll(cart.getItemList());
				list.add(item);
				cart.setItemList(list);
				
				return cart;
				
			}else {
				throw new ItemException("No Item found with ID: "+itemId);
			}
			
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}




}
