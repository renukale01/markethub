
package com.markethub.platform.marketplace.service;

import java.util.List;

import com.markethub.platform.marketplace.dto.OrderDTO;
import com.markethub.platform.marketplace.dto.PlaceOrderRequestDTO;

public interface OrderBuyerService {

	OrderDTO placeOrder(PlaceOrderRequestDTO placeOrderRequest);

	OrderDTO getOrderById(Long orderId);

	List<OrderDTO> getOrdersByBuyer(Long buyerId);

	OrderDTO cancelOrder(Long orderId, String cancellationReason);
}