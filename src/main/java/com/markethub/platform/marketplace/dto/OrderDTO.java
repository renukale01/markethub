package com.markethub.platform.marketplace.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
public class OrderDTO {

	private Long id;
	private String orderNumber;
	private Long buyerId;
	private Long shopId;
	private BigDecimal totalAmount;
	private BigDecimal deliveryCharges;
	private BigDecimal discountAmount;
	private BigDecimal finalAmount;
	private String paymentMethod;
	private String paymentStatus;
	private String orderStatus;
	private String deliveryAddress;
	private LocalDateTime estimatedDeliveryTime;
	private LocalDateTime confirmedAt;
	private LocalDateTime deliveredAt;
	private LocalDateTime cancelledAt;
	private String cancellationReason;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<OrderItemDTO> orderItems;
}