package com.ecommerce.ecommerce.feature.vendor.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OnboardVendorResponseDto {
    private String area;

    private String contactNumber;

    private String country;

    private String district;

    private String image;

    private String state;

    private String name;

    private String zipCode;
}
