package com.markethub.platform.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markethub.platform.marketplace.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
