package com.ecommerce.ecommerce.feature.vendor.service;

import com.ecommerce.ecommerce.feature.vendor.requestDto.OnboardVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.requestDto.UpdateVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.OnboardVendorResponseDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.UpdateVendorReponseDto;

public interface UpdateVendorDetailsService {

    UpdateVendorReponseDto updateVendor(UpdateVendorRequestDto vendorDetailsRequest, String id);
}
