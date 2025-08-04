package com.markethub.platform.marketplace.service;

import java.util.List;

import com.markethub.platform.marketplace.entity.Order;
import com.markethub.platform.marketplace.enums.OrderStatus;

public interface OrderService {

	List<Order> getOrdersByShopId(Long shopId);
	Order updateOrderStatus(Long orderId, OrderStatus newStatus);
	List<Order> getOrderBuyerId(Long buyerId);
	List<Order> getOrderByStatus(OrderStatus orderStatus);
	List<Order> searchOrders(Long buyerId, Long shopId, OrderStatus orderStatus);
}
