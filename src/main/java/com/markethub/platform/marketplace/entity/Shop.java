package com.markethub.platform.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shops")
public class Shop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    
    @Column(name = "owner_id")
    @JsonProperty("ownerId")
    private Long ownerId;
    
    @Column(name = "shop_name")
    @JsonProperty("shopName")
    private String shopName;
    
    @Column(name = "description")
    @JsonProperty("description")
    private String description;
    
    @Column(name = "category")
    @JsonProperty("category")
    private String category;
    
    @Column(name = "address")
    @JsonProperty("address")
    private String address;
    
    @Column(name = "city")
    @JsonProperty("city")
    private String city;
    
    @Column(name = "state")
    @JsonProperty("state")
    private String state;
    
    @Column(name = "pincode")
    @JsonProperty("pincode")
    private String pincode;
    
    @Column(name = "mobile_number")
    @JsonProperty("mobileNumber")
    private String mobileNumber;
    
    @Column(name = "email")
    @JsonProperty("email")
    private String email;
    
    @Column(name = "is_open")
    @JsonProperty("isOpen")
    private Boolean isOpen;
    
    @Column(name = "is_approved")
    @JsonProperty("isApproved")
    private Boolean isApproved;
    
    @Column(name = "rating")
    @JsonProperty("rating")
    private Double rating;

    // IMPORTANT: Default constructor
    public Shop() {}

    // IMPORTANT: Make sure ALL getters are public and follow naming convention
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    
    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    
    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }
    
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Boolean getIsOpen() { return isOpen; }
    public void setIsOpen(Boolean isOpen) { this.isOpen = isOpen; }
    
    public Boolean getIsApproved() { return isApproved; }
    public void setIsApproved(Boolean isApproved) { this.isApproved = isApproved; }
    
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
    
}