package com.markethub.platform.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markethub.platform.marketplace.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
