package com.markethub.platform.marketplace.service;

import java.util.List;

import com.markethub.platform.marketplace.entity.Shop;

public interface shopService {
	List<Shop> getShops();

	Shop getShopById(int id);

	void deleteShopById(int id);

	Shop addShops(Shop shop);

	Shop updateShopById(int id);

	Shop updateShopById(Shop shop);

	Shop updateApprovalStatus(Long shopId, boolean isApproved) ;
		
}
