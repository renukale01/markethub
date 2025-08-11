package com.markethub.platform.marketplace.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderRequestDTO {
	
	@NotNull(message = "Buyer ID is required")
	private Long buyerId;
	
	@NotNull(message = "Shop ID is required")
	private Long shopId;
	
	@NotEmpty(message = "Order items cannot be empty")
	private List<OrderItemRequestDTO> orderItems;
	
	@NotBlank(message = "Delivery address is required")
	private String deliveryAddress;
	
	private BigDecimal deliveryLatitude;
	private BigDecimal deliveryLongitude;
	
	private BigDecimal deliveryCharges = BigDecimal.ZERO;
	private BigDecimal discountAmount = BigDecimal.ZERO;
	
	@NotNull(message = "Payment method is required")
	private String paymentMethod; // COD, ONLINE, UPI
	
	private String customerNotes;
}