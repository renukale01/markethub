package com.markethub.platform.marketplace.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.markethub.platform.marketplace.dto.ProductDTO;
import com.markethub.platform.marketplace.entity.Product;
import com.markethub.platform.marketplace.service.ProductService;

@RestController
@RequestMapping("api/v1/admin")
public class ProductController {

	@Autowired
	public ProductService productservice;

	@GetMapping("/products")
	public List<Product> getProducts() {
		return productservice.getProducts();
	}

	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable long productId) {
		Optional<Product> product = productservice.getProductById(productId);
		return product.orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
	}

	@PostMapping("/product")
	public Product createProduct(@RequestBody ProductDTO productDto) {
		return productservice.createProduct(productDto);
	}

	@DeleteMapping("/products/{productId}")
	public String deleteProductById(@PathVariable long productId) {
		return productservice.deleteProductById(productId);
	}

	@PutMapping("/products/{productId}")
	public Optional<Product> updateProduct(@PathVariable long productId,@RequestBody ProductDTO productDto) {
		return productservice.updateProduct(productId,productDto);
	}
}
