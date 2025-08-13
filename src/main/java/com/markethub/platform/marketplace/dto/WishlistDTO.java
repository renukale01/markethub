package com.markethub.platform.marketplace.dto;

import java.time.LocalDateTime;

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
public class WishlistDTO {

	private Long id;
	private Long userId;
	private Long productId;
	private LocalDateTime createdAt;
}
