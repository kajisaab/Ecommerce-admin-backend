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
public class OnboardVendorRequestDto {

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

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    private String zipCode;
}
