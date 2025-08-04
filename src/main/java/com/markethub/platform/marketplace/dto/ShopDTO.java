package com.markethub.platform.marketplace.dto;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {

	private Long id;
	private Long ownerId;
	private String shopName;
	private String description;
	private String category;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String mobileNumber;
	private String email;
	private String shopImageUrl;
	private String shopLogoUrl;
	private Double rating;
	private Integer totalReviews;
	private Boolean isOpen;
	private String shopAgreement;
	private Boolean isApproved;
	private Time openingTime;
	private Time closingTime;
	private String shopLink;
	private String shopLicense;

}
