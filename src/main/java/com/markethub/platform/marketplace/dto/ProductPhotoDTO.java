package com.markethub.platform.marketplace.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPhotoDTO {

	private Long id;
	private Long productId;
	private String photoUrl;
	private Integer displayOrder;
	private LocalDateTime createdAt;

}