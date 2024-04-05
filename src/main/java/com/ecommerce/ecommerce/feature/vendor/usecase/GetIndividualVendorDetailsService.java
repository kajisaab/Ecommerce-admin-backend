package com.ecommerce.ecommerce.feature.vendor.usecase;

import com.ecommerce.ecommerce.common.StatusEnum;
import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.feature.vendor.Constant.VendorTypeEnum;
import com.ecommerce.ecommerce.feature.vendor.repository.VendorInfoRepository;
import com.ecommerce.ecommerce.feature.vendor.responseDto.IndividualVendorDetailsResopnseDto;
import com.ecommerce.ecommerce.feature.vendor.service.GetIndividualVendorDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetIndividualVendorDetailsService implements GetIndividualVendorDetailService {

    private final VendorInfoRepository vendorInfoRepository;

    @Override
    public IndividualVendorDetailsResopnseDto getVendorDetail(String id) {
        Map<String, Object> vendorData = this.vendorInfoRepository.getIndividualVendor(id);
        if(!vendorData.isEmpty()){
             var vendorDetails = new IndividualVendorDetailsResopnseDto();
             vendorDetails.vendorId = (String) vendorData.get("vendor_id");
             vendorDetails.businessName = (String) vendorData.get("vendor_business_name");
             vendorDetails.contactNo = (String) vendorData.get("contact_no");
             vendorDetails.email = (String) vendorData.get("email");
             vendorDetails.street = (String) vendorData.get("street");
             vendorDetails.district = (String) vendorData.get("district");
             vendorDetails.state = (String) vendorData.get("state");
             vendorDetails.municipality = (String) vendorData.get("municipality");
             vendorDetails.ruralMunicipality = (String) vendorData.get("rural_municipality");
             vendorDetails.country = (String) vendorData.get("country");
             vendorDetails.zipCode = (String) vendorData.get("zip_code");
             vendorDetails.vendorType = VendorTypeEnum.valueOf((String) vendorData.get("vendor_type")).getDisplayName(); // This is the way to convert the enum to the display Name
             vendorDetails.status = StatusEnum.valueOf((String) vendorData.get("status")).getDisplayName();
             vendorDetails.image = (String) vendorData.get("image");
             vendorDetails.bankName = (String) vendorData.get("bank_name");
             vendorDetails.accountHolder = (String) vendorData.get("account_holder");
             vendorDetails.accountNumber = (String) vendorData.get("account_number");
             vendorDetails.facebookUrl = (String) vendorData.get("facebook_url");
             vendorDetails.twitterUrl = (String) vendorData.get("twitter_url");
             vendorDetails.instagramUrl = (String) vendorData.get("instagram_url");
             return vendorDetails;
        }else {
            throw new BadRequestException("Cannot find the vendor with " + id);
        }
    }
}
