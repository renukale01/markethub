package com.markethub.platform.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markethub.platform.marketplace.entity.Order;
import com.markethub.platform.marketplace.enums.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByShopId(Long shopId);
	List<Order> findByBuyerId(Long shopId);
	List<Order> findByOrderStatus(OrderStatus orderStatus);
	List<Order> findByBuyerIdAndShopIdAndOrderStatus(Long buyerId, Long shopId, OrderStatus orderStatus);
}