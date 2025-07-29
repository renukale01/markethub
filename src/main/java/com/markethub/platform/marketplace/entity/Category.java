package com.markethub.platform.marketplace.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	@Column(name = "name", nullable = false)
	@JsonProperty("name")
	private String name;

	@Column(name = "description", columnDefinition = "TEXT")
	@JsonProperty("description")
	private String description;

	@Column(name = "icon_url", length = 500)
	@JsonProperty("iconUrl")
	private String iconUrl;

	@Column(name = "parent_id")
	@JsonProperty("parentId")
	private Long parentId;

	@Column(name = "is_active")
	@JsonProperty("isActive")
	private Boolean isActive = true;

	@Column(name = "created_at")
	@JsonProperty("createdAt")
	private LocalDateTime createdAt;

	// Self-referencing relationship for parent category
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id", insertable = false, updatable = false)
	private Category parentCategory;

	// One-to-Many relationship for subcategories
	@OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Category> subCategories;

}