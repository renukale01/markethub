package com.markethub.platform.marketplace.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markethub.platform.marketplace.dto.ProductDTO;
import com.markethub.platform.marketplace.entity.Product;
import com.markethub.platform.marketplace.entity.ProductPhoto;
import com.markethub.platform.marketplace.repository.ProductRepository;
import com.markethub.platform.marketplace.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(long id) {
		Optional<Product> product = productRepository.findById(id);
		return product;
	}

	@Override
	public Product createProduct(ProductDTO productDto) {

		Product product = Product.builder().shopId(productDto.getShopId()).categoryId(productDto.getCategoryId())
				.name(productDto.getName()).description(productDto.getDescription()).price(productDto.getPrice())
				.originalPrice(productDto.getOriginalPrice()).stockQuantity(productDto.getStockQuantity())
				.weight(productDto.getWeight()).dimensions(productDto.getDimensions())
				.rating(productDto.getRating() != null ? productDto.getRating() : BigDecimal.ZERO)
				.totalReviews(productDto.getTotalReviews() != null ? productDto.getTotalReviews() : 0)
				.totalSales(productDto.getTotalSales() != null ? productDto.getTotalSales() : 0)
				.status(productDto.getStatus()).productType(productDto.getProductType())
				.isFeatured(productDto.getIsFeatured()).capacity(productDto.getCapacity())
				.createdAt(productDto.getCreatedAt() != null ? productDto.getCreatedAt() : LocalDateTime.now())
				.updatedAt(productDto.getUpdatedAt() != null ? productDto.getUpdatedAt() : LocalDateTime.now()).build();

		// Handle product photos if they exist
		if (productDto.getProductPhotos() != null && !productDto.getProductPhotos().isEmpty()) {
			List<ProductPhoto> productPhotos = Optional.ofNullable(productDto.getProductPhotos())
					.orElse(Collections.emptyList()).stream()
					.map(photoDto -> ProductPhoto.builder().product(product).photoUrl(photoDto.getPhotoUrl())
							.displayOrder(photoDto.getDisplayOrder() != null ? photoDto.getDisplayOrder() : 0)
							.createdAt(photoDto.getCreatedAt() != null ? photoDto.getCreatedAt() : LocalDateTime.now())
							.build())
					.toList();

			// Set the product photos to the product
			product.setProductPhotos(productPhotos);
		}

		return productRepository.save(product);
	}

	@Override
	public String deleteProductById(long productId) {
		productRepository.deleteById(productId);
		return "deleted successfully";
	}

	@Override
	public Optional<Product> updateProduct(long productId, ProductDTO productDto) {
	    Optional<Product> optionalProduct = productRepository.findById(productId);
	    
	    if (optionalProduct.isPresent()) {
	        Product existingProduct = optionalProduct.get();
	        
	        // Update basic product fields
	        if (productDto.getName() != null) {
	            existingProduct.setName(productDto.getName());
	        }
	        if (productDto.getDescription() != null) {
	            existingProduct.setDescription(productDto.getDescription());
	        }
	        if (productDto.getPrice() != null) {
	            existingProduct.setPrice(productDto.getPrice());
	        }
	        if (productDto.getOriginalPrice() != null) {
	            existingProduct.setOriginalPrice(productDto.getOriginalPrice());
	        }
	        if (productDto.getStockQuantity() != null) {
	            existingProduct.setStockQuantity(productDto.getStockQuantity());
	        }
	        if (productDto.getWeight() != null) {
	            existingProduct.setWeight(productDto.getWeight());
	        }
	        if (productDto.getDimensions() != null) {
	            existingProduct.setDimensions(productDto.getDimensions());
	        }
	        if (productDto.getRating() != null) {
	            existingProduct.setRating(productDto.getRating());
	        }
	        if (productDto.getTotalReviews() != null) {
	            existingProduct.setTotalReviews(productDto.getTotalReviews());
	        }
	        if (productDto.getTotalSales() != null) {
	            existingProduct.setTotalSales(productDto.getTotalSales());
	        }
	        if (productDto.getStatus() != null) {
	            existingProduct.setStatus(productDto.getStatus());
	        }
	        if (productDto.getProductType() != null) {
	            existingProduct.setProductType(productDto.getProductType());
	        }
	        if (productDto.getIsFeatured() != null) {
	            existingProduct.setIsFeatured(productDto.getIsFeatured());
	        }
	        if (productDto.getCapacity() != null) {
	            existingProduct.setCapacity(productDto.getCapacity());
	        }
	        if (productDto.getCategoryId() != null) {
	            existingProduct.setCategoryId(productDto.getCategoryId());
	        }
	        
	        // Always update the updatedAt timestamp
	        existingProduct.setUpdatedAt(LocalDateTime.now());
	        
	        // Handle product photos update
	        if (productDto.getProductPhotos() != null) {
	            // Clear existing photos (due to orphanRemoval = true, they will be deleted)
	            existingProduct.getProductPhotos().clear();
	            
	            // Add new photos
	            if (!productDto.getProductPhotos().isEmpty()) {
	                List<ProductPhoto> newProductPhotos = productDto.getProductPhotos()
	                        .stream()
	                        .map(photoDto -> ProductPhoto.builder()
	                                .product(existingProduct)
	                                .photoUrl(photoDto.getPhotoUrl())
	                                .displayOrder(photoDto.getDisplayOrder() != null ? photoDto.getDisplayOrder() : 0)
	                                .createdAt(photoDto.getCreatedAt() != null ? photoDto.getCreatedAt() : LocalDateTime.now())
	                                .build())
	                        .toList();
	                
	                existingProduct.getProductPhotos().addAll(newProductPhotos);
	            }
	        }
	        
	        // Save and return the updated product
	        Product updatedProduct = productRepository.save(existingProduct);
	        return Optional.of(updatedProduct);
	    }
	    
	    return Optional.empty(); // Product not found



	}
}
