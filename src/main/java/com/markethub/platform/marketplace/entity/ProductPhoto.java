package com.markethub.platform.marketplace.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_photos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhoto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	@Column(name = "product_id", nullable = false, insertable = false, updatable = false)
	@JsonProperty("productId")
	private Long productId;

	@Column(name = "photo_url", nullable = false, length = 500)
	@JsonProperty("photoUrl")
	private String photoUrl;

	@Column(name = "display_order")
	@JsonProperty("displayOrder")
	private Integer displayOrder;

	@Column(name = "created_at")
	@JsonProperty("createdAt")
	private LocalDateTime createdAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	@JsonIgnore
	private Product product;
}