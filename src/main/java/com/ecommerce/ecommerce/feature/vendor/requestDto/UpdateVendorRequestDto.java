package com.ecommerce.ecommerce.feature.vendor.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVendorRequestDto {

    @NotNull(message = "Id cannot be empty")
    private String id;

    private String area;

    @NotNull(message = "Contact Number cannot be null")
    @NotBlank(message = "Contact Number cannot be empty")
    private String contactNumber;

    private String country;

    private String district;

    private String image;

    @NotNull(message = "State cannot be null")
    @NotBlank(message = "State cannot be empty")
    private String state;

    private String street;

    private String slug;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String vendorName;

    private String vendorType;

    private String zipCode;

    private String facebookUrl;

    private String instagramUrl;

    private String twitterUrl;


    @NotNull(message = "Account name cannot be null")
    @NotBlank(message = "Account name cannot be empty")
    private String accountHolder;

    @NotNull(message = "Account number cannot be null")
    @NotBlank(message = "Account number cannot be empty")
    private String accountNumber;

    @NotNull(message = "Bank name cannot be null")
    @NotBlank(message = "Bank name cannot be empty")
    private String bankName;
}
