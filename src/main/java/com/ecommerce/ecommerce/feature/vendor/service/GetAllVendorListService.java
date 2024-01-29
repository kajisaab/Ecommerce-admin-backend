package com.ecommerce.ecommerce.feature.vendor.service;

import com.ecommerce.ecommerce.feature.vendor.responseDto.VendorListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GetAllVendorListService {

    VendorListResponseDto getAllVendroDetailsList(String search, Pageable pageable);
}
