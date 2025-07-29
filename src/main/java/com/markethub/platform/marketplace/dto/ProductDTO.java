package com.markethub.platform.marketplace.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.markethub.platform.marketplace.enums.ProductStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Long id;
	private Long shopId;
	private Long categoryId;
	private String name;
	private String description;
	private BigDecimal price;
	private BigDecimal originalPrice;
	private Integer stockQuantity;
	private BigDecimal weight;
	private String dimensions;
	private BigDecimal rating;
	private Integer totalReviews;
	private Integer totalSales;
	private ProductStatus status;
	private Boolean isFeatured;
	private String capacity;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String categoryName;
	private String shopName;
	private List<ProductPhotoDTO> productPhotos;
	private Boolean isAddedToCart;
	private Boolean isAddedToWishlist;

}
