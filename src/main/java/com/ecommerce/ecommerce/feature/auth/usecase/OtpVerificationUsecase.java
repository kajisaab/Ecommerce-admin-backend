package com.ecommerce.ecommerce.feature.auth.usecase;

import com.ecommerce.ecommerce.feature.auth.requestDto.OtpVerificationUsecaseRequestDto;
import com.ecommerce.ecommerce.feature.auth.responseDto.OtpVerificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtpVerificationUsecase {

    public OtpVerificationResponse otpVerification(OtpVerificationUsecaseRequestDto request){
    return OtpVerificationResponse.builder().message(true).build();
    }

}
