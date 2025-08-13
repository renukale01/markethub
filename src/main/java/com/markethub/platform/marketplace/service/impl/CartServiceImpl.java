package com.markethub.platform.marketplace.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.markethub.platform.marketplace.dto.CartDTO;
import com.markethub.platform.marketplace.entity.Cart;
import com.markethub.platform.marketplace.repository.CartRepository;
import com.markethub.platform.marketplace.repository.UserRepository;
import com.markethub.platform.marketplace.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Cart addToCart(CartDTO cartDTO) {
		Optional<Cart> existingCart = cartRepo.findByUserIdAndProductId(cartDTO.getUserId(), cartDTO.getProductId());

		if (existingCart.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product is already in the cart for this user.");
		}

		Cart cart = Cart.builder().id(cartDTO.getId()).userId(cartDTO.getUserId()).productId(cartDTO.getProductId())
				.quantity(cartDTO.getQuantity()).createdAt(cartDTO.getCreatedAt()).build();

		userRepo.findById(cartDTO.getUserId()).ifPresent(u -> u.setIsAddedToCart(true));

		return cartRepo.save(cart);
	}

	@Override
	public List<Cart> getCart(Long userId) {
		List<Cart> list = cartRepo.findByUserId(userId);
		return list;
	}

	@Override
	public void removeCartProduct(Long userId, Long productId) {
		Optional<Cart> cartOpt = cartRepo.findByUserIdAndProductId(userId, productId);
		if (cartOpt.isPresent()) {
			cartRepo.deleteById(cartOpt.get().getId());
			System.out.println("Cart item deleted for userId=" + userId + ", productId=" + productId);
		} else {
			System.out.println("No Cart item found for userId=" + userId + ", productId=" + productId);
		}
	}

	@Override
	@Transactional
	public void clearCart(Long userId) {
		cartRepo.deleteAllByUserId(userId);
	}

	@Override
	public Cart updateCart(Long userId, Long productId, Integer quantity) {
		Optional<Cart> cartproduct = cartRepo.findByUserIdAndProductId(userId, productId);
		if (cartproduct.isPresent()) {
			Cart existingCartProduct = cartproduct.get();

			if (quantity != null) {
				existingCartProduct.setQuantity(quantity);
			}
			Cart updatedCartProduct = cartRepo.save(existingCartProduct);
			return updatedCartProduct;
		}

		return null;

	}

}
