package com.markethub.platform.marketplace.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	@Column(name = "order_id", nullable = false)
	@JsonProperty("orderId")
	private Long orderId;

	@Column(name = "product_id", nullable = false)
	@JsonProperty("productId")
	private Long productId;

	@Column(name = "quantity", nullable = false)
	@JsonProperty("quantity")
	private Integer quantity;

	@Column(name = "unit_price", nullable = false)
	@JsonProperty("unitPrice")
	private BigDecimal unitPrice;

	@Column(name = "total_price", nullable = false)
	@JsonProperty("totalPrice")
	private BigDecimal totalPrice;

	@Column(name = "product_name", nullable = false)
	@JsonProperty("productName")
	private String productName;

	@Column(name = "product_image_url")
	@JsonProperty("productImageUrl")
	private String productImageUrl;

	@Column(name = "created_at", nullable = false, updatable = false)
	@JsonProperty("createdAt")
	private Timestamp createdAt;

}