package com.markethub.platform.marketplace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markethub.platform.marketplace.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
	Optional<Wishlist> findByUserIdAndProductId(Long userId, Long productId);
	void deleteAllByUserId(Long userId);

}
