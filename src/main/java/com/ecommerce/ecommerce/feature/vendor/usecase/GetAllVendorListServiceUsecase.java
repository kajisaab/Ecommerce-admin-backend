package com.ecommerce.ecommerce.feature.vendor.usecase;

import com.ecommerce.ecommerce.feature.vendor.dto.VendorListDto;
import com.ecommerce.ecommerce.feature.vendor.dto.VendorPageInfoDto;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorInfoRepository;
import com.ecommerce.ecommerce.feature.vendor.responseDto.VendorListResponseDto;
import com.ecommerce.ecommerce.feature.vendor.service.GetAllVendorListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetAllVendorListServiceUsecase implements GetAllVendorListService {


    private final VendorInfoRepository vendorInfoRepository;

    @Override
    public VendorListResponseDto getAllVendroDetailsList(String search, Pageable pageable) {
        Page<Map<String, Object>> vendorPage = vendorInfoRepository.getAllVendor(search, pageable);
        Page<VendorListDto> vendorList = vendorPage.map(this::toListDto);
        VendorPageInfoDto pageDetails = new VendorPageInfoDto(vendorList.getPageable().getPageNumber(), vendorList.getPageable().getPageSize(),vendorPage.getTotalElements());

        // Convert List<VendorListDto> to VendorListDto[]
        VendorListDto[] vendorArray = vendorList.getContent().toArray(new VendorListDto[0]);

        return new VendorListResponseDto(vendorArray, pageDetails);
    }

    private VendorListDto toListDto(Map<String, Object> result) {
        VendorListDto vendor = new VendorListDto();
        vendor.setBusinessName((String) result.get("vendor_business_name"));
        vendor.setVendorId((String) result.get("vendor_id"));
        vendor.setContactNo((String) result.get("contact_no"));
        vendor.setImage((String) result.get("image"));
        vendor.setRating(0);
        return vendor;
    }
}
