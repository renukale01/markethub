package com.markethub.platform.marketplace.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "mobile_number", nullable = false, unique = true)
	@JsonProperty("mobileNumber")
	private String mobileNumber;

	@Column(name = "email", unique = true)
	@JsonProperty("email")
	private String email;

	@Column(name = "full_name")
	@JsonProperty("fullName")
	private String fullName;

	@Column(name = "profile_image_url")
	@JsonProperty("profileImageUrl")
	private String profileImageUrl;

	@Column(name = "user_type")
	@JsonProperty("userType")
	private Boolean userType;

	@Column(name = "is_active")
	@JsonProperty("isActive")
	private Boolean isActive;

	@Column(name = "password")
	@JsonProperty("password")
	private String password;
	
	@Column(name = "isAddedToCart")
	@JsonProperty("isAddedToCart")
	private Boolean isAddedToCart;

	@Column(name = "isAddedToWishlist")
	@JsonProperty("isAddedToWishlist")
	private Boolean isAddedToWishlist;

	@Column(name = "created_at", updatable = false)
	@JsonProperty("createdAt")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	@JsonProperty("updatedAt")
	private LocalDateTime updatedAt;

}
