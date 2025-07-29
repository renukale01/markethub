package com.markethub.platform.marketplace.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	private Long id;
	private String name;
	private String description;
	private String iconUrl;
	private Long parentId;
	private Boolean isActive;
	private LocalDateTime createdAt;
	private String parentCategoryName;
	private List<CategoryDTO> subCategories;
	private Integer productCount;
}
