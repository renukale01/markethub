package com.markethub.platform.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markethub.platform.marketplace.entity.Shop;
import com.markethub.platform.marketplace.service.ShopService;

@RestController
@RequestMapping("api/v1/admin")
public class ShopController {

	@Autowired
	public ShopService shopservice;

	@GetMapping("/shops")
	public List<Shop> getShops() {
		return shopservice.getShops();
	}
}
