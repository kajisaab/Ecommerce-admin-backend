package com.ecommerce.ecommerce.feature.vendor.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorListResponseDto {
    public String vendorId;
    public String vendorName;
    public String contactNo;
    public Integer rating;
    public String image;
}

