package com.markethub.platform.marketplace.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markethub.platform.marketplace.dto.OrderDTO;
import com.markethub.platform.marketplace.dto.PlaceOrderRequestDTO;
import com.markethub.platform.marketplace.service.OrderBuyerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
public class OrderBuyerController {

	@Autowired
	private OrderBuyerService orderService;

	/**
	 * Place a new order
	 */
	@PostMapping("/place")
	public ResponseEntity<Map<String, Object>> placeOrder(@Valid @RequestBody PlaceOrderRequestDTO placeOrderRequest) {
		Map<String, Object> response = new HashMap<>();
		try {
			OrderDTO orderDTO = orderService.placeOrder(placeOrderRequest);
			response.put("success", true);
			response.put("message", "Order placed successfully");
			response.put("data", orderDTO);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", "Failed to place order: " + e.getMessage());
			response.put("data", null);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Get order by ID
	 */
	@GetMapping("/{orderId}")
	public ResponseEntity<Map<String, Object>> getOrderById(@PathVariable Long orderId) {
		Map<String, Object> response = new HashMap<>();
		try {
			OrderDTO orderDTO = orderService.getOrderById(orderId);
			response.put("success", true);
			response.put("message", "Order retrieved successfully");
			response.put("data", orderDTO);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", "Failed to retrieve order: " + e.getMessage());
			response.put("data", null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Get all orders for a buyer
	 */
	@GetMapping("/buyer/{buyerId}")
	public ResponseEntity<Map<String, Object>> getOrdersByBuyer(@PathVariable Long buyerId) {
		Map<String, Object> response = new HashMap<>();
		try {
			List<OrderDTO> orders = orderService.getOrdersByBuyer(buyerId);
			response.put("success", true);
			response.put("message", "Orders retrieved successfully");
			response.put("data", orders);
			response.put("count", orders.size());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", "Failed to retrieve orders: " + e.getMessage());
			response.put("data", null);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Cancel order
	 */
	@PutMapping("/{orderId}/cancel")
	public ResponseEntity<Map<String, Object>> cancelOrder(@PathVariable Long orderId,
			@RequestBody Map<String, String> cancelRequest) {
		Map<String, Object> response = new HashMap<>();
		try {
			String cancellationReason = cancelRequest.get("cancellationReason");
			if (cancellationReason == null || cancellationReason.trim().isEmpty()) {
				cancellationReason = "Cancelled by user";
			}

			OrderDTO orderDTO = orderService.cancelOrder(orderId, cancellationReason);
			response.put("success", true);
			response.put("message", "Order cancelled successfully");
			response.put("data", orderDTO);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", "Failed to cancel order: " + e.getMessage());
			response.put("data", null);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

}