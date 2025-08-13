package com.markethub.platform.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import com.markethub.platform.marketplace.entity.Order;
import com.markethub.platform.marketplace.enums.OrderStatus;
import com.markethub.platform.marketplace.service.OrderService;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

	@Autowired
	private OrderService Orderservice;
	
	@GetMapping ("/shop/{shopId}")
	public List<Order> getOrders(@PathVariable Long shopId){
		return  Orderservice.getOrdersByShopId(shopId);
	}
	 @PutMapping("/{orderId}/status")
	 public Order updateOrderStatus(@PathVariable Long orderId,@RequestParam OrderStatus status) {
		 return Orderservice.updateOrderStatus(orderId,status);
	 }
	 
	 @GetMapping("/buyer-order/{buyerId}")
	 public List<Order> getOrderBuyerId(@PathVariable Long buyerId){
		 return Orderservice.getOrderBuyerId(buyerId);
	 }
	 @GetMapping("/status/{status}")
	 public List<Order> getOrderByStatus(@PathVariable("status") OrderStatus orderStatus){
		 return Orderservice.getOrderByStatus(orderStatus);
	 }
	 @GetMapping("/search")
	    public List<Order> searchOrders(
	        @RequestParam(required = false) Long buyerId,
	        @RequestParam(required = false) Long shopId,
	        @RequestParam(required = false) OrderStatus orderStatus
	    ) {
	        return Orderservice.searchOrders(buyerId, shopId, orderStatus);
	    }
	 
}
