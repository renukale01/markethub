package com.markethub.platform.marketplace.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.markethub.platform.marketplace.enums.OrderStatus;
import com.markethub.platform.marketplace.enums.PaymentMethod;
import com.markethub.platform.marketplace.enums.PaymentStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	@Column(name = "order_number", unique = true, nullable = false)
	@JsonProperty("orderNumber")
	private String orderNumber;

	@Column(name = "buyer_id", nullable = false)
	@JsonProperty("buyerId")
	private Long buyerId;

	@Column(name = "shop_id", nullable = false)
	@JsonProperty("shopId")
	private Long shopId;

	@Column(name = "total_amount", nullable = false)
	@JsonProperty("totalAmount")
	private BigDecimal totalAmount;

	@Column(name = "delivery_charges")
	@JsonProperty("deliveryCharges")
	private BigDecimal deliveryCharges = BigDecimal.ZERO;

	@Column(name = "discount_amount")
	@JsonProperty("discountAmount")
	private BigDecimal discountAmount = BigDecimal.ZERO;

	@Column(name = "final_amount", nullable = false)
	@JsonProperty("finalAmount")
	private BigDecimal finalAmount;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method")
	@JsonProperty("paymentMethod")
	private PaymentMethod paymentMethod;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	@JsonProperty("paymentStatus")
	private PaymentStatus paymentStatus;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status")
	@JsonProperty("orderStatus")
	private OrderStatus orderStatus;

	@Column(name = "delivery_address", nullable = false, columnDefinition = "TEXT")
	@JsonProperty("deliveryAddress")
	private String deliveryAddress;

	@Column(name = "estimated_delivery_time")
	@JsonProperty("estimatedDeliveryTime")
	private LocalDateTime estimatedDeliveryTime;

	@Column(name = "confirmed_at")
	@JsonProperty("confirmedAt")
	private LocalDateTime confirmedAt;

	@Column(name = "delivered_at")
	@JsonProperty("deliveredAt")
	private LocalDateTime deliveredAt;

	@Column(name = "cancelled_at")
	@JsonProperty("cancelledAt")
	private LocalDateTime cancelledAt;

	@Column(name = "cancellation_reason", columnDefinition = "TEXT")
	@JsonProperty("cancellationReason")
	private String cancellationReason;

	@Column(name = "created_at", nullable = false, updatable = false)
	@JsonProperty("createdAt")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@JsonProperty("updatedAt")
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonProperty("orderItems")
	private List<OrderItem> orderItems;

}