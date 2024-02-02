package com.ecommerce.ecommerce.feature.vendor.usecase;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.feature.vendor.Constant.VendorTypeEnum;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorAddress;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorBankDetail;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorSocialSetting;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorAddressRepository;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorBankDetailsRepository;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorInfoRepository;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorSocialSettingRepository;
import com.ecommerce.ecommerce.feature.vendor.requestDto.UpdateVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.responseDto.UpdateVendorReponseDto;
import com.ecommerce.ecommerce.feature.vendor.service.UpdateVendorDetailsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateVendorDetail implements UpdateVendorDetailsService {

    private final VendorInfoRepository vendorInfoRepository;
    private final VendorBankDetailsRepository vendorBankDetailsRepository;
    private final VendorAddressRepository vendorAddressRepository;
    private final VendorSocialSettingRepository vendorSocialSettingRepository;

    @Override
    public UpdateVendorReponseDto updateVendor(UpdateVendorRequestDto request, String id) {
        VendorInfo vendorInfo = vendorInfoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Cannot find the vendor with the id " + id));


        // update VendorInfo entity
        vendorInfo.setContactNo(request.getContactNumber());
        vendorInfo.setVendorBusinessName(request.getBusinessName());
        vendorInfo.setVendorType(VendorTypeEnum.fromDisplayName(request.getVendorType()));
        vendorInfo.setImage(request.getImage());

        // update VendorBankDetail entity
        VendorBankDetail bankDetails = vendorInfo.getVendorBankDetail();
        bankDetails.setBankName(request.getBankName());
        bankDetails.setAccountNumber(request.getAccountNumber());
        bankDetails.setAccountHolder(request.getAccountHolder());

        // update VendorSocial Setting entity
        VendorSocialSetting socialSetting = vendorInfo.getVendorSocialSetting();
        socialSetting.setFacebookUrl(request.getFacebookUrl());
        socialSetting.setTwitterUrl(request.getTwitterUrl());
        socialSetting.setInstagramUrl(request.getInstagramUrl());

        // update Vendor address entity;
        VendorAddress address = vendorInfo.getVendorAddress();
        address.setState(request.getState());
        address.setProvince(request.getProvince());
        address.setWardNo(request.getWardNo());
        address.setMunicipality(request.getMunicipality());
        address.setRuralMunicipality(request.getRuralMunicipality());
        address.setZipCode(request.getZipCode());

        //Save updated entities
        vendorInfoRepository.save(vendorInfo);
        vendorBankDetailsRepository.save(bankDetails);
        vendorAddressRepository.save(address);
        vendorSocialSettingRepository.save(socialSetting);


        return new UpdateVendorReponseDto("Successfully updated the vendor");
    };
}
