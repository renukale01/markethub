package com.markethub.platform.marketplace.dto;

import java.sql.Time;

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

	public ShopDTO() {}

	public ShopDTO(Long id, Long ownerId, String shopName, String description, String category,
	               String address, String city, String state, String pincode,
	               String mobileNumber, String email, String shopImageUrl, String shopLogoUrl,
	               Double rating, Integer totalReviews, Boolean isOpen,
	               String shopAgreement, Boolean isApproved, Time openingTime,
	               Time closingTime, String shopLink, String shopLicense) {
		this.id = id;
		this.ownerId = ownerId;
		this.shopName = shopName;
		this.description = description;
		this.category = category;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.shopImageUrl = shopImageUrl;
		this.shopLogoUrl = shopLogoUrl;
		this.rating = rating;
		this.totalReviews = totalReviews;
		this.isOpen = isOpen;
		this.shopAgreement = shopAgreement;
		this.isApproved = isApproved;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.shopLink = shopLink;
		this.shopLicense = shopLicense;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShopImageUrl() {
		return shopImageUrl;
	}

	public void setShopImageUrl(String shopImageUrl) {
		this.shopImageUrl = shopImageUrl;
	}

	public String getShopLogoUrl() {
		return shopLogoUrl;
	}

	public void setShopLogoUrl(String shopLogoUrl) {
		this.shopLogoUrl = shopLogoUrl;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(Integer totalReviews) {
		this.totalReviews = totalReviews;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getShopAgreement() {
		return shopAgreement;
	}

	public void setShopAgreement(String shopAgreement) {
		this.shopAgreement = shopAgreement;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Time getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Time openingTime) {
		this.openingTime = openingTime;
	}

	public Time getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(Time closingTime) {
		this.closingTime = closingTime;
	}

	public String getShopLink() {
		return shopLink;
	}

	public void setShopLink(String shopLink) {
		this.shopLink = shopLink;
	}

	public String getShopLicense() {
		return shopLicense;
	}

	public void setShopLicense(String shopLicense) {
		this.shopLicense = shopLicense;
	}
}
