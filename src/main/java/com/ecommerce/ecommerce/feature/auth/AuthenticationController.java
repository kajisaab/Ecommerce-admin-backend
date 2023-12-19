package com.ecommerce.ecommerce.feature.auth;

import com.ecommerce.ecommerce.feature.auth.requestDto.OtpVerificationUsecaseRequestDto;
import com.ecommerce.ecommerce.feature.auth.requestDto.SigninUsecaseRequest;
import com.ecommerce.ecommerce.feature.auth.requestDto.SignupUsecaseRequest;
import com.ecommerce.ecommerce.feature.auth.usecase.LoginUsecase;
import com.ecommerce.ecommerce.feature.auth.usecase.OtpVerificationUsecase;
import com.ecommerce.ecommerce.feature.auth.usecase.SignupUsecase;
import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.responseHandler.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final SignupUsecase signupUsecase;
    private final LoginUsecase loginUsecase;
    private final OtpVerificationUsecase otpVerificationUsecase;

    @PostMapping("/register")
    public ResponseEntity<Object>register(@RequestBody SignupUsecaseRequest request) throws BadRequestException {
        return ResponseHandler.responseBuilder("User Created", HttpStatus.OK, signupUsecase.register(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<Object>authenticate(@RequestBody SigninUsecaseRequest request) throws BadRequestException{
        return ResponseHandler.responseBuilder("SUCCESS", HttpStatus.OK, loginUsecase.authenticate(request));
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<Object>verifyOtp(@RequestBody OtpVerificationUsecaseRequestDto request) throws BadRequestException{
        return ResponseHandler.responseBuilder("SUCCESS", HttpStatus.OK, otpVerificationUsecase.otpVerification(request));
    }
}
