package com.markethub.platform.marketplace.service;

import java.util.List;
import java.util.Optional;

import com.markethub.platform.marketplace.dto.ProductDTO;
import com.markethub.platform.marketplace.entity.Product;

public interface ProductService {
	List<Product> getProducts();

	Optional<Product> getProductById(long id);

	Product createProduct(ProductDTO productDto);

	String deleteProductById(long productId);

	Optional<Product> updateProduct(long productId,ProductDTO productDto);
}
