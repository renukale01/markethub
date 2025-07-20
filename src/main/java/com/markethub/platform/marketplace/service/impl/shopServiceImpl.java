package com.markethub.platform.marketplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markethub.platform.marketplace.entity.Shop;
import com.markethub.platform.marketplace.repository.ShopRepository;
import com.markethub.platform.marketplace.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopRepository shopRepository;

	@Override
	public List<Shop> getShops() {
		return shopRepository.findAll();
	}
}
