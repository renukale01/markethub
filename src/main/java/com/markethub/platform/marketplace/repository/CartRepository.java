package com.markethub.platform.marketplace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markethub.platform.marketplace.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	Optional<Cart> findByUserIdAndProductId(Long userId, Long productId);
	
	List<Cart> findByUserId(Long userId);
	
	void deleteAllByUserId(Long userId);
	
}
