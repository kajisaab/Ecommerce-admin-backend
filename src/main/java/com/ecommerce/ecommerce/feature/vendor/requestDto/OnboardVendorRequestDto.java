package com.ecommerce.ecommerce.feature.vendor.requestDto;

import com.ecommerce.ecommerce.feature.vendor.Constant.VendorTypeEnum;
import com.ecommerce.ecommerce.feature.vendor.dto.VendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.dto.VendorUserRequestDto;
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
    private VendorRequestDto vendor;
    private VendorUserRequestDto user;
}


