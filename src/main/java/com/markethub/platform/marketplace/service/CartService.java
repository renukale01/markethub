package com.markethub.platform.marketplace.service;

import java.util.List;

import com.markethub.platform.marketplace.dto.CartDTO;
import com.markethub.platform.marketplace.entity.Cart;

public interface CartService {

	Cart addToCart(CartDTO cartDto);

	List<Cart> getCart(Long userId);

	void removeCartProduct(Long userId, Long productId); 
	
	void clearCart(Long userId);
	
	Cart updateCart(Long userId, Long productId, Integer quantity);

}
