package com.ecommerce.ecommerce.feature.vendor.service;

import com.ecommerce.ecommerce.feature.vendor.requestDto.OnboardVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.OnboardVendorResponseDto;

public interface OnboardVendorService {
    OnboardVendorResponseDto onboardVendor(OnboardVendorRequestDto vendorDetailsRequest);
}
