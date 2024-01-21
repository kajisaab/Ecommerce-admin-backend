package com.ecommerce.ecommerce.feature.vendor.dto;

import com.ecommerce.ecommerce.feature.vendor.entity.VendorBankDetail;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorInfo;
import com.ecommerce.ecommerce.feature.vendor.entity.VendorSocialSetting;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorListDto {
    private String vendorId;
    private String vendorName;
    private String contactNo;
    private String area;
    private String street;
    private String district;
    private String state;
    private String country;
    private String zipCode;
    private String vendorType;
    private String status;
    private String image;

    private String bankName;
    private String accountHolder;
    private String accountNumber;

    private String facebookUrl;
    private String twitterUrl;
    private String instagramUrl;

    public void VendorResponseDTO(VendorInfo vendorInfo, VendorBankDetail bankDetail, VendorSocialSetting socialSetting) {
        this.vendorId = vendorInfo.getId();
        this.vendorName = vendorInfo.getVendorName();
        this.contactNo = vendorInfo.getContactNo();
        this.area = vendorInfo.getArea();
        this.street = vendorInfo.getStreet();
        this.district = vendorInfo.getDistrict();
        this.state = vendorInfo.getState();
        this.country = vendorInfo.getCountry();
        this.zipCode = vendorInfo.getZipCode();
        this.vendorType = vendorInfo.getVendorType().getDisplayName();
        this.status = vendorInfo.getStatus().name();
        this.image = vendorInfo.getImage();

        this.bankName = bankDetail.getBankName();
        this.accountHolder = bankDetail.getAccountHolder();
        this.accountNumber = bankDetail.getAccountNumber();

        this.facebookUrl = socialSetting.getFacebookUrl();
        this.twitterUrl = socialSetting.getTwitterUrl();
        this.instagramUrl = socialSetting.getInstagramUrl();
    }
}
