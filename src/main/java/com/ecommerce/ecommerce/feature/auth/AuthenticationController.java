package com.ecommerce.ecommerce.feature.auth;

import com.ecommerce.ecommerce.feature.auth.requestDto.SigninUsecaseRequestDto;
import com.ecommerce.ecommerce.feature.auth.requestDto.SignupUsecaseRequestDto;
import com.ecommerce.ecommerce.feature.auth.usecase.LoginUsecase;
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
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final SignupUsecase signupUsecase;
    private final LoginUsecase loginUsecase;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody SignupUsecaseRequestDto request) throws BadRequestException {
        return ResponseHandler.responseBuilder("User Created", HttpStatus.OK, signupUsecase.register(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> authenticate(@RequestBody SigninUsecaseRequestDto request) throws BadRequestException {
        return ResponseHandler.responseBuilder("SUCCESS", HttpStatus.OK, loginUsecase.authenticate(request));
    }
}
