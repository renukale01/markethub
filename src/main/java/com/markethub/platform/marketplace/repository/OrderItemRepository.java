package com.markethub.platform.marketplace.repository;

import com.markethub.platform.marketplace.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
	/**
	 * Find order items by order ID
	 */
	List<OrderItem> findByOrderId(Long orderId);
	
	/**
	 * Find order items by product ID
	 */
	List<OrderItem> findByProductId(Long productId);
	
	/**
	 * Find order items by order ID ordered by created date
	 */
	List<OrderItem> findByOrderIdOrderByCreatedAtAsc(Long orderId);
	
	/**
	 * Count total quantity sold for a product
	 */
	@Query("SELECT SUM(oi.quantity) FROM OrderItem oi WHERE oi.productId = :productId")
	Long getTotalQuantitySoldByProductId(@Param("productId") Long productId);
	
	/**
	 * Get total revenue for a product
	 */
	@Query("SELECT SUM(oi.totalPrice) FROM OrderItem oi WHERE oi.productId = :productId")
	Double getTotalRevenueByProductId(@Param("productId") Long productId);
	
	/**
	 * Delete order items by order ID
	 */
	void deleteByOrderId(Long orderId);
}