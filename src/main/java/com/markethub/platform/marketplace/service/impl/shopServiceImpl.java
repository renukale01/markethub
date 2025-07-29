package com.markethub.platform.marketplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markethub.platform.marketplace.entity.Shop;
import com.markethub.platform.marketplace.repository.ShopRepository;
import com.markethub.platform.marketplace.service.shopService;

@Service
public class shopServiceImpl implements shopService {

	@Autowired
	private ShopRepository shopRepository;

	@Override
	public List<Shop> getShops() {
		return shopRepository.findAll();
	}

	@Override
	public Shop addShops(Shop shop) {
		shop.setId(null);
		return shopRepository.save(shop);
	}

	@Override
	public Shop getShopById(int id) {
		return shopRepository.findById((long) id).orElse(null);
	}

	@Override
	public Shop updateShopById(Shop shop) {
		List<Shop> allShops = shopRepository.findAll();
		Shop updatedShop = null;

		for (Shop existing : allShops) {
			if (existing.getId().equals(shop.getId())) {
				existing.setShopName(shop.getShopName());
				existing.setDescription(shop.getDescription());
				existing.setCategory(shop.getCategory());
				existing.setAddress(shop.getAddress());
				existing.setCity(shop.getCity());
				existing.setState(shop.getState());
				existing.setPincode(shop.getPincode());
				existing.setMobileNumber(shop.getMobileNumber());
				existing.setEmail(shop.getEmail());
				existing.setIsOpen(shop.getIsOpen());
				existing.setIsApproved(shop.getIsApproved());
				existing.setRating(shop.getRating());

				updatedShop = shopRepository.save(existing);
				break;
			}
		}

		if (updatedShop == null) {
			throw new RuntimeException("Shop not found with id " + shop.getId());
		}

		return updatedShop;
	}

	@Override
	public void deleteShopById(int id) {
		shopRepository.deleteById((long) id);
	}

	@Override
	public Shop updateShopById(int id) {
		return null;
	}
}
