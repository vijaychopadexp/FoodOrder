package com.test.foodorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.foodorder.exception.AuthorizationException;
import com.test.foodorder.exception.CartException;
import com.test.foodorder.exception.ItemException;
import com.test.foodorder.model.FoodBasket;
import com.test.foodorder.service.FoodBasketService;
import com.test.foodorder.service.impl.UserSessionService;


@RestController
@RequestMapping("/basket")
public class FoodBasketController {
	@Autowired
	FoodBasketService cartService;

	@Autowired
	UserSessionService userSessionService;

	@PostMapping("/register")
	public ResponseEntity<FoodBasket> saveCartDetails(@RequestParam String key, @RequestBody FoodBasket fc)
			throws CartException, AuthorizationException {
		Integer sessionId = userSessionService.getUserSessionId(key);

		if (fc != null && sessionId != null) {
			FoodBasket f = cartService.saveCart(fc);
			return new ResponseEntity<FoodBasket>(f, HttpStatus.CREATED);
		}
		throw new CartException();
	}

	@PutMapping("/add/{cartId}/{itemId}")
	public ResponseEntity<FoodBasket> addItemToCart(@PathVariable("cartId") Integer cartId,
			@PathVariable("itemId") Integer itemId) throws CartException, ItemException {
		FoodBasket updatedCart = cartService.addItem(cartId, itemId);
		return new ResponseEntity<FoodBasket>(updatedCart, HttpStatus.ACCEPTED);
	}

	@GetMapping("/view/{cartId}")
	public FoodBasket getCartByCartId(@PathVariable("cartId") Integer cartId, @RequestParam String key)
			throws AuthorizationException, CartException {

		Integer sessionId = userSessionService.getUserSessionId(key);
		if (sessionId != null)
			return cartService.viewCart(cartId);
		else
			throw new CartException();

	}

}
