package com.markethub.platform.marketplace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.markethub.platform.marketplace.entity.Order;
import com.markethub.platform.marketplace.enums.OrderStatus;
import com.markethub.platform.marketplace.enums.PaymentStatus;

@Repository
public interface OrderBuyerRepository extends JpaRepository<Order, Long> {

	/**
	 * Find order by order number
	 */
	Optional<Order> findByOrderNumber(String orderNumber);

	/**
	 * Find orders by buyer ID ordered by created date (newest first)
	 */
	List<Order> findByBuyerIdOrderByCreatedAtDesc(Long buyerId);

	/**
	 * Find orders by shop ID ordered by created date (newest first)
	 */
	List<Order> findByShopIdOrderByCreatedAtDesc(Long shopId);

	/**
	 * Find orders by buyer ID and order status
	 */
	List<Order> findByBuyerIdAndOrderStatusOrderByCreatedAtDesc(Long buyerId, OrderStatus orderStatus);

	/**
	 * Find orders by shop ID and order status
	 */
	List<Order> findByShopIdAndOrderStatusOrderByCreatedAtDesc(Long shopId, OrderStatus orderStatus);

	/**
	 * Find orders by payment status
	 */
	List<Order> findByPaymentStatusOrderByCreatedAtDesc(PaymentStatus paymentStatus);

	/**
	 * Count orders by shop ID and order status
	 */
	@Query("SELECT COUNT(o) FROM Order o WHERE o.shopId = :shopId AND orderStatus = :orderStatus")
	Long countByShopIdAndOrderStatus(@Param("shopId") Long shopId, @Param("orderStatus") OrderStatus orderStatus);

	/**
	 * Count orders by buyer ID and order status
	 */
	@Query("SELECT COUNT(o) FROM Order o WHERE o.buyerId = :buyerId AND o.orderStatus = :orderStatus")
	Long countByBuyerIdAndOrderStatus(@Param("buyerId") Long buyerId,
			@Param("orderStatus") OrderStatus orderStatus);

	/**
	 * Find orders by shop ID with pending payment
	 */
	@Query("SELECT o FROM Order o WHERE o.shopId = :shopId AND o.paymentStatus = 'PENDING' ORDER BY o.createdAt DESC")
	List<Order> findPendingPaymentOrdersByShop(@Param("shopId") Long shopId);
}