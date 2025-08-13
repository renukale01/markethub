package com.markethub.platform.marketplace.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String mobileNumber;
    private String email;
    private String fullName;
    private Boolean userType;
    private String profileImageUrl;
    private Boolean isActive;
    private String password;
    private Boolean isAddedToCart;
	private Boolean isAddedToWishlist;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
