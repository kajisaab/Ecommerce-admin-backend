package com.ecommerce.ecommerce.feature.vendor.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorDetailDto {
    private String id;
    private String vendorName;
    private String contactNo;
    private String email;
    private String vendorType;
    private String status;
    private String image;
    private String bankName;
    private String accountHolder;
    private String accountNumber;
    private String facebookUrl;
    private String twitterUrl;
    private String instagramUrl;
}

