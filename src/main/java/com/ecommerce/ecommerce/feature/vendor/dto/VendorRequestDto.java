package com.ecommerce.ecommerce.feature.vendor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorRequestDto {
    @NotNull(message = "Contact Number cannot be null")
    @NotBlank(message = "Contact Number cannot be empty")
    private String contactNumber;

    @NotNull(message = "Country cannot be null")
    @NotBlank(message = "Country cannot be empty")
    private String country;


    @NotNull(message = "Phone Number cannot be null")
    @NotBlank(message = "Phone Number cannot be empty")
    @Size(min = 10, max = 10, message = "Phone Number must be of 10 digit")
    private String phoneNumber;

    @NotNull(message = "Province cannot be null")
    @NotBlank(message = "Province cannot be empty")
    private String province;

    private String image;

    @NotNull(message = "State cannot be null")
    @NotBlank(message = "State cannot be empty")
    private String state;

    private String street;

    private String wardNo;

    private String municipality;

    private String ruralMunicipality;

    @NotNull(message = "Business Name cannot be null")
    @NotBlank(message = "Business Name cannot be empty")
    private String vendorBusinessName;

    @NotNull(message = "Vendor Email cannot be null")
    @NotBlank(message = "Vendor Email cannot be empty")
    private String vendorEmail;

    private String vendorUserName;

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
