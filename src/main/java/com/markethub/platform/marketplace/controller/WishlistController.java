package com.markethub.platform.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markethub.platform.marketplace.dto.WishlistDTO;
import com.markethub.platform.marketplace.entity.Wishlist;
import com.markethub.platform.marketplace.service.WishlistService;

@RestController
@RequestMapping("api/v1/buyer")
public class WishlistController {

	@Autowired
	public WishlistService wishlistservice;

	@PostMapping("/wishlist")
	public Wishlist addToWishlist(@RequestBody WishlistDTO wishlistDto) {
		return wishlistservice.addToWishlist(wishlistDto);
	}

	@GetMapping("/wishlist/{userId}")
	public List<Wishlist> getWishlist(@PathVariable Long userId) {
		return wishlistservice.getWishlist(userId);
	}

	@DeleteMapping("/wishlist/{userId}/{productId}")
	public void removeWishlistProduct(@PathVariable Long userId, @PathVariable Long productId) {
		wishlistservice.removeWishlistProduct(userId, productId);
	}

	@DeleteMapping("/wishlist/{userId}")
	public String clearWishlist(@PathVariable Long userId) {
		wishlistservice.clearWishlist(userId);
		return "Wishlist cleared for user " + userId;
	}
}
