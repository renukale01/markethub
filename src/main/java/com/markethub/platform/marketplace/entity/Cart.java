package com.markethub.platform.marketplace.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_cart", uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "product_id" }))
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	@Column(name = "user_id", nullable = false)
	@JsonProperty("userId")
	private Long userId;

	@Column(name = "product_id", nullable = false)
	@JsonProperty("productId")
	private Long productId;

	@Column(name = "quantity", nullable = false)
	@JsonProperty("quantity")
	private Integer quantity;

	@Column(name = "created_at")
	@JsonProperty("createdAt")
	private LocalDateTime createdAt;
}