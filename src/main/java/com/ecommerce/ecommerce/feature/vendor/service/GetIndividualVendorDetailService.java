package com.ecommerce.ecommerce.feature.vendor.service;

import com.ecommerce.ecommerce.feature.vendor.responseDto.IndividualVendorDetailsResopnseDto;

public interface GetIndividualVendorDetailService {

    IndividualVendorDetailsResopnseDto getVendorDetail(String id);
}
