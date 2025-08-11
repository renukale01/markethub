package com.markethub.platform.marketplace.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

	private Long id;
	private Long orderId;
	private Long productId;
	private Integer quantity;
	private BigDecimal unitPrice;
	private BigDecimal totalPrice;
	private String productName;
	private String productImageUrl;
	private LocalDateTime createdAt;
}