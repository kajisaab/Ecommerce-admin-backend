package com.ecommerce.ecommerce.feature.vendor.responseDto;

import com.ecommerce.ecommerce.feature.vendor.dto.VendorListDto;
import com.ecommerce.ecommerce.feature.vendor.dto.VendorPageInfoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorListResponseDto {
    public VendorListDto[] list;
    public VendorPageInfoDto pageInfo;
}


