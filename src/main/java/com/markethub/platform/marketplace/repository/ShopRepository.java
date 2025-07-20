package com.markethub.platform.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markethub.platform.marketplace.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
