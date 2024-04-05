package com.ecommerce.ecommerce.feature.vendor.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IndividualVendorDetailsResopnseDto {
    public String vendorId;
    public String businessName;
    public String contactNo;
    public String email;
    public String street;
    public String district;
    public String state;
    public String country;
    public String zipCode;
    public String municipality;
    public String ruralMunicipality;
    public String vendorType;
    public String status;
    public String image;
    public String bankName;
    public String accountHolder;
    public String accountNumber;
    public String facebookUrl;
    public String twitterUrl;
    public String instagramUrl;
}
