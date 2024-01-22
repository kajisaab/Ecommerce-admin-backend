package com.ecommerce.ecommerce.feature.vendor.service;

import com.ecommerce.ecommerce.feature.vendor.dto.VendorListDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.VendorListResponseDto;

import java.util.List;

public interface GetAllVendorList {

    List<VendorListResponseDto> getAllVendroDetailsList();
}
