package com.markethub.platform.marketplace.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
	private String paymentMethod; // COD, ONLINE, UPI
	private String paymentStatus; // PENDING, PAID, FAILED
	private String orderStatus; // PENDING, CONFIRMED, PREPARING, READY, DELIVERED, CANCELLED
	private String deliveryAddress;
	private Timestamp estimatedDeliveryTime;
	private Timestamp confirmedAt;
	private Timestamp deliveredAt;
	private Timestamp cancelledAt;
	private String cancellationReason;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private List<OrderItemDTO> orderItems;
}