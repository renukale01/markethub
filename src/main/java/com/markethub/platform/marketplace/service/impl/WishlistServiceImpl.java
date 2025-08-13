package com.markethub.platform.marketplace.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markethub.platform.marketplace.dto.WishlistDTO;
import com.markethub.platform.marketplace.entity.User;
import com.markethub.platform.marketplace.entity.Wishlist;
import com.markethub.platform.marketplace.repository.UserRepository;
import com.markethub.platform.marketplace.repository.WishlistRepository;
import com.markethub.platform.marketplace.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository wishlistRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Wishlist addToWishlist(WishlistDTO wishlistDTO) {

		Wishlist wishlist = Wishlist.builder().id(wishlistDTO.getId()).userId(wishlistDTO.getUserId())
				.productId(wishlistDTO.getProductId()).createdAt(wishlistDTO.getCreatedAt()).build();

		Optional<User> user = userRepo.findById(wishlistDTO.getUserId());
		user.get().setIsAddedToWishlist(true);

		return wishlistRepo.save(wishlist);
	}

	@Override
	public List<Wishlist> getWishlist(Long userId) {
		List<Wishlist> list = wishlistRepo.findAll();
		return list;
	}

//	@Override
//	public void removeWishlistProduct(Long userId, Long productId) {
//		wishlistRepo.findByUserIdAndProductId(userId, productId)
//				.ifPresent(wishlist -> wishlistRepo.deleteById(wishlist.getId()));
//
//		Optional<Wishlist> item = wishlistRepo.findByUserIdAndProductId(userId, productId);
//
//		wishlistRepo.deleteById(item.get().getId());
//
//	}
	@Override
	public void removeWishlistProduct(Long userId, Long productId) {
	    Optional<Wishlist> wishlistOpt = wishlistRepo.findByUserIdAndProductId(userId, productId);
	    if (wishlistOpt.isPresent()) {
	        wishlistRepo.deleteById(wishlistOpt.get().getId());
	        System.out.println("Wishlist item deleted for userId=" + userId + ", productId=" + productId);
	    } else {
	        System.out.println("No wishlist item found for userId=" + userId + ", productId=" + productId);
	    }
	}
	
	@Override
	@Transactional
	public void clearWishlist(Long userId) {
		wishlistRepo.deleteAllByUserId(userId);
	}
	


}
