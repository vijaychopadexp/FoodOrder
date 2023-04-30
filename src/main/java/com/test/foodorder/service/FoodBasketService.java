package com.test.foodorder.service;

import com.test.foodorder.exception.CartException;
import com.test.foodorder.exception.ItemException;
import com.test.foodorder.model.FoodBasket;

public interface FoodBasketService {
	public FoodBasket saveCart(FoodBasket cart) throws CartException;

	public FoodBasket addItem(Integer cartId, Integer itemId) throws CartException, ItemException;

	public FoodBasket viewCart(Integer cartId) throws CartException;

}
