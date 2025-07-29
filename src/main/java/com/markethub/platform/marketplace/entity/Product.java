package com.markethub.platform.marketplace.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.markethub.platform.marketplace.enums.ProductStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	@Column(name = "shop_id", nullable = false)
	@JsonProperty("shopId")
	private Long shopId;

	@Column(name = "category_id")
	@JsonProperty("categoryId")
	private Long categoryId;

	@Column(name = "name", nullable = false)
	@JsonProperty("name")
	private String name;

	@Column(name = "description", columnDefinition = "TEXT")
	@JsonProperty("description")
	private String description;

	@Column(name = "price", nullable = false, precision = 10, scale = 2)
	@JsonProperty("price")
	private BigDecimal price;

	@Column(name = "original_price", precision = 10, scale = 2)
	@JsonProperty("originalPrice")
	private BigDecimal originalPrice;

	@Column(name = "stock_quantity", nullable = false)
	@JsonProperty("stockQuantity")
	private Integer stockQuantity;

	@Column(name = "weight", precision = 8, scale = 2)
	@JsonProperty("weight")
	private BigDecimal weight;

	@Column(name = "dimensions", length = 100)
	@JsonProperty("dimensions")
	private String dimensions;

	@Column(name = "rating", precision = 3, scale = 2)
	@JsonProperty("rating")
	private BigDecimal rating ;

	@Column(name = "total_reviews")
	@JsonProperty("totalReviews")
	private Integer totalReviews;

	@Column(name = "total_sales")
	@JsonProperty("totalSales")
	private Integer totalSales;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	@JsonProperty("status")
	private ProductStatus status;

	@Column(name = "product_type")
	@JsonProperty("productType")
	private String productType;

	@Column(name = "is_featured")
	@JsonProperty("isFeatured")
	private Boolean isFeatured;

	@Column(name = "capacity", length = 50)
	@JsonProperty("capacity")
	private String capacity;

	@Column(name = "created_at")
	@JsonProperty("createdAt")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@JsonProperty("updatedAt")
	private LocalDateTime updatedAt;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id", insertable = false, updatable = false)
	private Shop shop;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@OrderBy("displayOrder ASC")
	private List<ProductPhoto> productPhotos;

	@JsonProperty("isAddedToCart")
	private Boolean isAddedToCart;

	@JsonProperty("isAddedToWishlist")
	private Boolean isAddedToWishlist;
}