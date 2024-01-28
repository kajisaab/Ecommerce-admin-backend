package com.ecommerce.ecommerce.feature.vendor.service;

import com.ecommerce.ecommerce.feature.vendor.responseDto.IndividualVendorDetailsResopnseDto;

public interface GetIndividualVendorDetail {

    IndividualVendorDetailsResopnseDto getVendorDetail(String id);
}
