package com.ecommerce.ecommerce.feature.vendor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorListDto {
    public String vendorId;
    public String businessName;
    public String contactNo;
    public Integer rating;
    public String image;
}
