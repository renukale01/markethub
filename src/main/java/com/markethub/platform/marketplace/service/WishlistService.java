package com.markethub.platform.marketplace.service;

import java.util.List;

import com.markethub.platform.marketplace.dto.WishlistDTO;
import com.markethub.platform.marketplace.entity.Product;
import com.markethub.platform.marketplace.entity.Wishlist;

public interface WishlistService {

	Wishlist addToWishlist(WishlistDTO wishlistDto);

	List<Wishlist> getWishlist(Long userId);

	void removeWishlistProduct(Long userId, Long productId); 
	
	void clearWishlist(Long userId);

}
