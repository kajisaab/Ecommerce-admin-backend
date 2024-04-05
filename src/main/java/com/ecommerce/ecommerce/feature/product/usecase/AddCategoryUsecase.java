package com.ecommerce.ecommerce.feature.product.usecase;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.validation.ValidationUtils;
import com.ecommerce.ecommerce.feature.product.requestDto.AddCategoryRequestDto;
import com.ecommerce.ecommerce.feature.product.responseDto.AddCategoryResponseDto;
import com.ecommerce.ecommerce.feature.product.service.AddCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AddCategoryUsecase implements AddCategoryService {

    @Override
    public AddCategoryResponseDto addCategoryDetails(AddCategoryRequestDto addCategoryRequest) {
        String violations = ValidationUtils.validate(addCategoryRequest);
        if(!Objects.isNull(violations)){
            throw new BadRequestException(violations);
        }
        return null;
    }
}
