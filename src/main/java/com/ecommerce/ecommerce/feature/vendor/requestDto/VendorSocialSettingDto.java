package com.ecommerce.ecommerce.feature.vendor.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorSocialSettingDto {

    private String facebookUrl;

    private String instagramUrl;

    private String twitterUrl;


}
