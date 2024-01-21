package com.ecommerce.ecommerce.feature.vendor.usecase;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.validation.ValidationUtils;
import com.ecommerce.ecommerce.feature.vendor.dto.VendorListDto;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorInfoRepository;
import com.ecommerce.ecommerce.feature.vendor.requestDto.OnboardVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.OnboardVendorResponseDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.VendorListResponseDto;
import com.ecommerce.ecommerce.feature.vendor.service.GetAllVendorList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetAllVendorListUsecase implements GetAllVendorList {


    private final VendorInfoRepository vendorInfoRepository;

    @Override
    public List<VendorListDto> getAllVendroDetailsList() {
        List<VendorListDto> vendorDetailsList = vendorInfoRepository.getAllVendor();

        return VendorListResponseDto.builder().vendorId(vendorDetailsList.get().getVendorId())
    }
}
