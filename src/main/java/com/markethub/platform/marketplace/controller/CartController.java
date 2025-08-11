package com.markethub.platform.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.markethub.platform.marketplace
.dto.CartDTO;
import com.markethub.platform.marketplace.entity.Cart;
import com.markethub.platform.marketplace.service.CartService;

@RestController
@RequestMapping("api/v1/buyer")
public class CartController {

	@Autowired
	public CartService cartservice;

	@PostMapping("/cart")
	public Cart addToCart(@RequestBody CartDTO cartDto) {
		return cartservice.addToCart(cartDto);
	}

	@GetMapping("/cart/{userId}")
	public List<Cart> getCart(@PathVariable Long userId) {
		return cartservice.getCart(userId);
	}

	@DeleteMapping("/cart/{userId}/{productId}")
	public void removeCartProduct(@PathVariable Long userId, @PathVariable Long productId) {
		cartservice.removeCartProduct(userId, productId);
	}

	@DeleteMapping("/cart/{userId}")
	public String clearCart(@PathVariable Long userId) {
		cartservice.clearCart(userId);
		return "Cart cleared for user " + userId;
	}
	
	@PutMapping("/cart/{userId}/{productId}")
	public Cart updateCart(@PathVariable Long userId, @PathVariable Long productId, @RequestParam Integer quantity){
		return cartservice.updateCart(userId, productId, quantity);
	}
}
