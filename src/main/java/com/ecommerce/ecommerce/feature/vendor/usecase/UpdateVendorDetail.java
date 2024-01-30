package com.ecommerce.ecommerce.feature.vendor.usecase;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorSocialSetting;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorInfoRepository;
import com.ecommerce.ecommerce.feature.vendor.requestDto.UpdateVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.UpdateVendorReponseDto;
import com.ecommerce.ecommerce.feature.vendor.service.UpdateVendorDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateVendorDetail implements UpdateVendorDetailsService {

    private final VendorInfoRepository vendorInfoRepository;

    private final OnboardVendorUsecase onboardVendorUsecase;
    @Override
    public UpdateVendorReponseDto updateVendor(UpdateVendorRequestDto vendorDetailsRequest, String id) {
        Optional<VendorInfo> vendorDetails = this.vendorInfoRepository.findById(id);

        if(vendorDetails.isPresent() ) {

            vendorInfo.setId(id);

            //vendor bank detail
            vendor.setId(vendorBankDetailsId);
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
            throw new BadRequestException("Cannot find the vendor with the id " + id);
        }
    }
}
