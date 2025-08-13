package com.markethub.platform.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.markethub.platform.marketplace.entity.Shop;
import com.markethub.platform.marketplace.service.shopService;

@RestController
@RequestMapping("api/v1/admin")
public class shopController {

	@Autowired
	private shopService shopservice;

	@GetMapping("/shops")
	public List<Shop> getShops() {
		return shopservice.getShops();
	}
	
    @PostMapping("/shops")
	public Shop addShop(@RequestBody Shop shop) {
	    shop.setId(null);
	    return shopservice.addShops(shop);
	}
	
	@GetMapping("/shops/{id}")
	public Shop getShopById(@PathVariable int id) {
	    return shopservice.getShopById(id);
	}
	
	@PutMapping("/shops/{id}")
    public Shop updateShop(@PathVariable int id, @RequestBody Shop shop) {
        shop.setId((long) id);
        return shopservice.updateShopById(shop);
    }
	
	
	@DeleteMapping("/shops/{id}")
    public void deleteShop(@PathVariable int id) {
        shopservice.deleteShopById(id);
    }
	
	@PutMapping("/{shopId}/approval")
	public Shop approveShop(@PathVariable Long shopId, @RequestParam boolean isApproved) {
	    return shopservice.updateApprovalStatus(shopId, isApproved);
	}
}
