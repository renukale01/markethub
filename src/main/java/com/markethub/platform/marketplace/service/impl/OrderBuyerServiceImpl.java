package com.markethub.platform.marketplace.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markethub.platform.marketplace.dto.OrderDTO;
import com.markethub.platform.marketplace.dto.OrderItemDTO;
import com.markethub.platform.marketplace.dto.OrderItemRequestDTO;
import com.markethub.platform.marketplace.dto.PlaceOrderRequestDTO;
import com.markethub.platform.marketplace.entity.Order;
import com.markethub.platform.marketplace.entity.OrderItem;
import com.markethub.platform.marketplace.enums.OrderStatus;
import com.markethub.platform.marketplace.enums.PaymentMethod;
import com.markethub.platform.marketplace.enums.PaymentStatus;
import com.markethub.platform.marketplace.repository.OrderBuyerRepository;
import com.markethub.platform.marketplace.repository.OrderItemRepository;
import com.markethub.platform.marketplace.service.OrderBuyerService;

@Service
@Transactional
public class OrderBuyerServiceImpl implements OrderBuyerService {

	@Autowired
	private OrderBuyerRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public OrderDTO placeOrder(PlaceOrderRequestDTO placeOrderRequest) {
		try {
			// Generate unique order number
			String orderNumber = generateOrderNumber();

			// Calculate total amount from order items
			BigDecimal totalAmount = calculateTotalAmount(placeOrderRequest.getOrderItems());

			// Calculate final amount
			BigDecimal finalAmount = totalAmount.add(placeOrderRequest.getDeliveryCharges())
					.subtract(placeOrderRequest.getDiscountAmount());

			// Create Order entity
			Order order = new Order();
			order.setOrderNumber(orderNumber);
			order.setBuyerId(placeOrderRequest.getBuyerId());
			order.setShopId(placeOrderRequest.getShopId());
			order.setTotalAmount(totalAmount);
			order.setDeliveryCharges(placeOrderRequest.getDeliveryCharges());
			order.setDiscountAmount(placeOrderRequest.getDiscountAmount());
			order.setFinalAmount(finalAmount);
			order.setPaymentMethod(PaymentMethod.valueOf(placeOrderRequest.getPaymentMethod().toUpperCase()));
			order.setPaymentStatus(PaymentStatus.PENDING);
			order.setOrderStatus(OrderStatus.PENDING);
			order.setDeliveryAddress(placeOrderRequest.getDeliveryAddress());
			order.setCreatedAt(LocalDateTime.now());

			// Save order
			Order savedOrder = orderRepository.save(order);

			// Create and save order items
			List<OrderItem> orderItems = placeOrderRequest.getOrderItems().stream()
					.map(itemRequest -> createOrderItem(savedOrder.getId(), itemRequest)).collect(Collectors.toList());

			List<OrderItem> savedOrderItems = orderItemRepository.saveAll(orderItems);

			// Convert to DTO and return
			return convertToOrderDTO(savedOrder, savedOrderItems);

		} catch (Exception e) {
			throw new RuntimeException("Failed to place order: " + e.getMessage(), e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public OrderDTO getOrderById(Long orderId) {
		Optional<Order> orderOpt = orderRepository.findById(orderId);
		if (orderOpt.isEmpty()) {
			throw new RuntimeException("Order not found with ID: " + orderId);
		}

		Order order = orderOpt.get();
		List<OrderItem> orderItems = orderItemRepository.findByOrderId(orderId);

		return convertToOrderDTO(order, orderItems);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderDTO> getOrdersByBuyer(Long buyerId) {
		List<Order> orders = orderRepository.findByBuyerIdOrderByCreatedAtDesc(buyerId);
		return orders.stream().map(order -> {
			List<OrderItem> orderItems = orderItemRepository.findByOrderId(order.getId());
			return convertToOrderDTO(order, orderItems);
		}).collect(Collectors.toList());
	}

	@Override
	public OrderDTO cancelOrder(Long orderId, String cancellationReason) {
		Optional<Order> orderOpt = orderRepository.findById(orderId);
		if (orderOpt.isEmpty()) {
			throw new RuntimeException("Order not found with ID: " + orderId);
		}

		Order order = orderOpt.get();

		// Check if order can be cancelled
		if (order.getOrderStatus() == OrderStatus.DELIVERED) {
			throw new RuntimeException("Cannot cancel delivered order");
		}

		order.setOrderStatus(OrderStatus.CANCELLED);
		order.setCancellationReason(cancellationReason);
		order.setCancelledAt(LocalDateTime.now());

		Order savedOrder = orderRepository.save(order);
		List<OrderItem> orderItems = orderItemRepository.findByOrderId(orderId);

		return convertToOrderDTO(savedOrder, orderItems);
	}

	// Helper methods
	private String generateOrderNumber() {
		String timestamp = String.valueOf(System.currentTimeMillis());
		String randomPart = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
		return "ORD" + timestamp.substring(timestamp.length() - 6) + randomPart;
	}

	private BigDecimal calculateTotalAmount(List<OrderItemRequestDTO> orderItems) {
		return orderItems.stream().map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private OrderItem createOrderItem(Long orderId, OrderItemRequestDTO itemRequest) {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderId(orderId);
		orderItem.setProductId(itemRequest.getProductId());
		orderItem.setQuantity(itemRequest.getQuantity());
		orderItem.setUnitPrice(itemRequest.getUnitPrice());
		orderItem.setTotalPrice(itemRequest.getUnitPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity())));
		orderItem.setProductName(itemRequest.getProductName());
		orderItem.setProductImageUrl(itemRequest.getProductImageUrl());
		orderItem.setCreatedAt(LocalDateTime.now());
		return orderItem;
	}

	private OrderDTO convertToOrderDTO(Order order, List<OrderItem> orderItems) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(order.getId());
		orderDTO.setOrderNumber(order.getOrderNumber());
		orderDTO.setBuyerId(order.getBuyerId());
		orderDTO.setShopId(order.getShopId());
		orderDTO.setTotalAmount(order.getTotalAmount());
		orderDTO.setDeliveryCharges(order.getDeliveryCharges());
		orderDTO.setDiscountAmount(order.getDiscountAmount());
		orderDTO.setFinalAmount(order.getFinalAmount());
		orderDTO.setPaymentMethod(order.getPaymentMethod().name());
		orderDTO.setPaymentStatus(order.getPaymentStatus().name());
		orderDTO.setOrderStatus(order.getOrderStatus().name());
		orderDTO.setDeliveryAddress(order.getDeliveryAddress());
		orderDTO.setEstimatedDeliveryTime(order.getEstimatedDeliveryTime());
		orderDTO.setConfirmedAt(order.getConfirmedAt());
		orderDTO.setDeliveredAt(order.getDeliveredAt());
		orderDTO.setCancelledAt(order.getCancelledAt());
		orderDTO.setCancellationReason(order.getCancellationReason());
		orderDTO.setCreatedAt(order.getCreatedAt());
		orderDTO.setUpdatedAt(order.getUpdatedAt());

		// Convert order items
		List<OrderItemDTO> orderItemDTOs = orderItems.stream().map(this::convertToOrderItemDTO)
				.collect(Collectors.toList());
		orderDTO.setOrderItems(orderItemDTOs);

		return orderDTO;
	}

	private OrderItemDTO convertToOrderItemDTO(OrderItem orderItem) {
		OrderItemDTO dto = new OrderItemDTO();
		dto.setId(orderItem.getId());
		dto.setOrderId(orderItem.getOrderId());
		dto.setProductId(orderItem.getProductId());
		dto.setQuantity(orderItem.getQuantity());
		dto.setUnitPrice(orderItem.getUnitPrice());
		dto.setTotalPrice(orderItem.getTotalPrice());
		dto.setProductName(orderItem.getProductName());
		dto.setProductImageUrl(orderItem.getProductImageUrl());
		dto.setCreatedAt(LocalDateTime.now());
		return dto;
	}
}