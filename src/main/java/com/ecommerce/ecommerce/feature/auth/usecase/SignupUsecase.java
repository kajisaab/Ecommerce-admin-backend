package com.ecommerce.ecommerce.feature.auth.usecase;

import com.ecommerce.ecommerce.core.validation.ValidationUtils;
import com.ecommerce.ecommerce.feature.auth.enumConstant.RoleEnum;
import com.ecommerce.ecommerce.feature.auth.enumConstant.UserTypeEnum;
import com.ecommerce.ecommerce.feature.auth.responseDto.SignupResponse;
import com.ecommerce.ecommerce.feature.auth.requestDto.SignupUsecaseRequestDto;
import com.ecommerce.ecommerce.feature.auth.dto.GenerateOtpCodeDto;
import com.ecommerce.ecommerce.feature.auth.service.OtpService;
import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.jwt.JwtService;
import com.ecommerce.ecommerce.email.impl.EmailServiceImpl;
import com.ecommerce.ecommerce.feature.auth.entity.OtpSetting;
import com.ecommerce.ecommerce.feature.auth.entity.User;
import com.ecommerce.ecommerce.feature.auth.entity.UserCredential;
import com.ecommerce.ecommerce.feature.auth.repository.OtpSettingRepository;
import com.ecommerce.ecommerce.feature.auth.repository.UserCredentialRepository;
import com.ecommerce.ecommerce.feature.auth.repository.UserDetailsRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SignupUsecase {
    private final UserDetailsRepository userDetailsRepository;
    private final UserCredentialRepository userCredentialRepository;
    private final OtpSettingRepository otpSettingRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final OtpService otpService;
    private final EmailServiceImpl emailService;

    public SignupResponse register(@RequestBody SignupUsecaseRequestDto request){
        String violations = ValidationUtils.validate(request);
        if(!Objects.isNull(violations)){
            throw new BadRequestException(violations);
        }
        boolean isUserAlreadyRegistered = isNewUser(request.getEmail());
        if(!isUserAlreadyRegistered){
            var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName()).email(request.getEmail()).userName(request.getUserName()).role(RoleEnum.ADMIN).userType(UserTypeEnum.VENDOR).phoneNumber(request.getPhoneNumber()).password(passwordEncoder.encode((request.getPassword()))).build();
            User savedUser = userDetailsRepository.save(user);

            UserCredential userCredential = new UserCredential();
            userCredential.setUserDetails(savedUser);
            UserCredential savedCred = userCredentialRepository.save(userCredential);

            GenerateOtpCodeDto generatedOtp = this.otpService.getOtp();
            var otpDetails = OtpSetting.builder().userCredential(savedCred).otp(generatedOtp.getOtpCode()).expiry_date_time(generatedOtp.getExpiryTime()).build();
            otpSettingRepository.save(otpDetails);
//            emailService.sendHtmlEmail(generatedOtp.getOtpCode(), request.getEmail());
            return SignupResponse.builder().message("Successfully Created user").build();
        }
        throw new BadRequestException("User with the email " + request.getEmail() + " already exists");
    }


    private boolean isNewUser(String email){
        return userDetailsRepository.existsByEmail(email);
    }
}
