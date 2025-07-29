package com.markethub.platform.marketplace.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shops")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}