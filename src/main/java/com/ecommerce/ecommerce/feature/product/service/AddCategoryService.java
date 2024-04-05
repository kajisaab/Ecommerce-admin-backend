package com.ecommerce.ecommerce.feature.product.service;

import com.ecommerce.ecommerce.feature.product.requestDto.AddCategoryRequestDto;
import com.ecommerce.ecommerce.feature.product.responseDto.AddCategoryResponseDto;

public interface AddCategoryService {

    AddCategoryResponseDto addCategoryDetails(AddCategoryRequestDto addCategoryRequest);

}
