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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllVendorListUsecase implements GetAllVendorList {


    private final VendorInfoRepository vendorInfoRepository;

    @Override
    public List<VendorListResponseDto> getAllVendroDetailsList() {
        List<Map<String, Object>> venderList = vendorInfoRepository.getAllVendor();
        return venderList.stream()
                .filter(ts -> !Objects.isNull(ts))
                .map(this::toListDto)
                .toList();

    }

    private VendorListResponseDto toListDto(Map<String,Object> result) {
       var vendor = new VendorListResponseDto();
       vendor.vendorName =(String) result.get("vendor_name");
       vendor.vendorId = (String) result.get("vendor_id");
       vendor.contactNo = (String) result.get("contact_no");
       vendor.image = (String) result.get("image");
       vendor.rating = (Integer) result.get("rating");
       return vendor;
    }
}
