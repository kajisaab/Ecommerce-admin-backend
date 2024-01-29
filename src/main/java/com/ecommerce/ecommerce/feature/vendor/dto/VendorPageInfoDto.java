package com.ecommerce.ecommerce.feature.vendor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorPageInfoDto {
    public Integer pageNumber;
    public Integer pageSize;
    public Long totalRecord;
}
