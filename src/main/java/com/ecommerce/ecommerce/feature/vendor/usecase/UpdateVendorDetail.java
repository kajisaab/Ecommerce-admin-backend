package com.ecommerce.ecommerce.feature.vendor.usecase;

import com.ecommerce.ecommerce.common.StatusEnum;
import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.feature.vendor.Constant.VendorTypeEnum;
import com.ecommerce.ecommerce.feature.vendor.dto.VendorDetailDto;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorBankDetail;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorSocialSetting;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorBankDetailsRepository;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorInfoRepository;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorSocialSettingRepository;
import com.ecommerce.ecommerce.feature.vendor.requestDto.OnboardVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.requestDto.UpdateVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.OnboardVendorResponseDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.UpdateVendorReponseDto;
import com.ecommerce.ecommerce.feature.vendor.service.UpdateVendorDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateVendorDetail implements UpdateVendorDetailsService {

    private final VendorInfoRepository vendorInfoRepository;
    private final VendorSocialSettingRepository vendorSocialSettingRepository;
    private final VendorBankDetailsRepository vendorBankDetailsRepository;
    @Override
    public UpdateVendorReponseDto updateVendor(UpdateVendorRequestDto vendorDetailsRequest) {
        Optional<VendorInfo> vendorDetails = this.vendorInfoRepository.findById(vendorDetailsRequest.getId());
        Optional<Map<String, Object>> vendorBankDetails = this.vendorBankDetailsRepository.getVendorbankDetailsBVendorId(vendorDetailsRequest.getId());
        Optional<Map<String, Object>> vendorSocialSetting = this.vendorSocialSettingRepository.getVendorSocialSettingByVendorId(vendorDetailsRequest.getId());

        if(vendorDetails.isPresent() && vendorBankDetails.isPresent() && vendorSocialSetting.isPresent()) {

            String vendorBankDetailsId = (String) vendorBankDetails.get().get("id");
            String vendorSocialSettingId = (String) vendorSocialSetting.get().get("id");

            VendorInfo vendorInfo = mapToVendorInfo(vendorDetailsRequest);

            //vendor bank detail
            VendorBankDetail bankDetail = vendorInfo.getVendorBankDetail();
            bankDetail.setId(vendorBankDetailsId);
            bankDetail.setVendorInfo(vendorInfo);
            vendorBankDetailsRepository.save(bankDetail);

            // VendorSocialSetting
            VendorSocialSetting socialSetting = vendorInfo.getVendorSocialSetting();
            socialSetting.setId(vendorSocialSettingId);
            socialSetting.setVendorInfo(vendorInfo);
            vendorSocialSettingRepository.save(socialSetting);


            vendorInfoRepository.save(vendorInfo);


            return new UpdateVendorReponseDto("Successfully Updated Vendor");

        }else{
            throw new BadRequestException("Cannot find the vendor with the id " + vendorDetailsRequest.getId());
        }


    }

    private VendorInfo mapToVendorInfo(UpdateVendorRequestDto dto) {
        // Mapping logic...

        // setting the vendor Info details;
        VendorInfo vendorInfo = new VendorInfo();
        vendorInfo.setId(dto.getId());
        vendorInfo.setVendorName(dto.getVendorName());
        vendorInfo.setContactNo(dto.getContactNumber());
        vendorInfo.setArea(dto.getArea());
        vendorInfo.setStreet(dto.getStreet());
        vendorInfo.setDistrict(dto.getDistrict());
        vendorInfo.setState(dto.getState());
        vendorInfo.setCountry(dto.getCountry());
        vendorInfo.setZipCode(dto.getZipCode());
        vendorInfo.setSlug(dto.getSlug());
        vendorInfo.setVendorType(VendorTypeEnum.fromDisplayName(dto.getVendorType()));
        vendorInfo.setStatus(StatusEnum.PENDING);
        vendorInfo.setImage(dto.getImage()); // replace the hardcode value to dto.getImage();

        // setting the vendor bank details;
        VendorBankDetail vendorBankDetail = new VendorBankDetail();

        vendorBankDetail.setBankName(dto.getBankName());
        vendorBankDetail.setAccountHolder(dto.getAccountHolder());
        vendorBankDetail.setAccountNumber(dto.getAccountNumber());
        vendorBankDetail.setVendorInfo(vendorInfo);
        vendorInfo.setVendorBankDetail(vendorBankDetail);

        // setting the vendor social setting
        VendorSocialSetting vendorSocialSetting = new VendorSocialSetting();
        vendorSocialSetting.setFacebookUrl(dto.getFacebookUrl());
        vendorSocialSetting.setInstagramUrl(dto.getInstagramUrl());
        vendorSocialSetting.setTwitterUrl(dto.getTwitterUrl());
        vendorSocialSetting.setVendorInfo(vendorInfo);
        vendorInfo.setVendorSocialSetting(vendorSocialSetting);

        return vendorInfo;
    };
}
