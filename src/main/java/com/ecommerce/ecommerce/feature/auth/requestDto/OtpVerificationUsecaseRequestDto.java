package com.ecommerce.ecommerce.feature.auth.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OtpVerificationUsecaseRequestDto {
    @NotNull
    public String otp;
}
