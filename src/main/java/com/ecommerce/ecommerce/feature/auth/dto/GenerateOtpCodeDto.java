package com.ecommerce.ecommerce.feature.auth.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenerateOtpCodeDto {
    private int otpCode;
    private String expiryTime;
}
