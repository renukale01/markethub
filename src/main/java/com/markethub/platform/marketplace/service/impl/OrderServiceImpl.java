package com.markethub.platform.marketplace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.markethub.platform.marketplace.entity.Order;
import com.markethub.platform.marketplace.enums.OrderStatus;
import com.markethub.platform.marketplace.repository.OrderRepository;
import com.markethub.platform.marketplace.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getOrdersByShopId(Long shopId){
		return orderRepository.findByShopId(shopId);
	}
	
	@Override
	public Order updateOrderStatus(Long orderId,OrderStatus newStatus) {
		Order order = orderRepository.findById(orderId).orElseThrow(()->new RuntimeException ("Order not found with id: " + orderId));
			order.setOrderStatus(newStatus);
			return orderRepository.save(order);
	}
	
	@Override
	public List<Order> getOrderBuyerId(Long buyerId){
		return orderRepository.findByBuyerId(buyerId);
	}
	
	@Override
	public List<Order> getOrderByStatus(OrderStatus orderStatus){
		return orderRepository.findByOrderStatus(orderStatus);
	}
	
	@Override
    public List<Order> searchOrders(Long buyerId, Long shopId, OrderStatus orderStatus) {
        return orderRepository.findByBuyerIdAndShopIdAndOrderStatus(buyerId, shopId, orderStatus);
    }

}
