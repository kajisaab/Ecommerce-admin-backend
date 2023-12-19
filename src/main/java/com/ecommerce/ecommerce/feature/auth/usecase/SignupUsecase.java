package com.ecommerce.ecommerce.feature.auth.usecase;

import com.ecommerce.ecommerce.feature.auth.responseDto.SignupResponse;
import com.ecommerce.ecommerce.feature.auth.requestDto.SignupUsecaseRequest;
import com.ecommerce.ecommerce.feature.auth.dto.GenerateOtpCodeDto;
import com.ecommerce.ecommerce.feature.auth.service.OtpService;
import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.jwt.JwtService;
import com.ecommerce.ecommerce.email.impl.EmailServiceImpl;
import com.ecommerce.ecommerce.feature.auth.entity.OtpSetting;
import com.ecommerce.ecommerce.feature.auth.entity.User;
import com.ecommerce.ecommerce.feature.auth.entity.UserCredential;
import com.ecommerce.ecommerce.feature.auth.enumConstant.Role;
import com.ecommerce.ecommerce.feature.auth.repository.OtpSettingRepository;
import com.ecommerce.ecommerce.feature.auth.repository.UserCredentialRepository;
import com.ecommerce.ecommerce.feature.auth.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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


    public SignupResponse register(SignupUsecaseRequest request){
        boolean isUserAlreadyRegistered = isNewUser(request.getEmail());
        if(!isUserAlreadyRegistered){
            var user = User.builder().first_name(request.getFirstName()).last_name(request.getLastName()).email(request.getEmail()).user_name(request.getUserName()).role(Role.USER).build();
            User savedUser = userDetailsRepository.save(user);

            UserCredential userCredential = new UserCredential();
            userCredential.setUserDetails(savedUser);
            userCredential.setPassword(passwordEncoder.encode((request.getPassword())));
            UserCredential savedCred = userCredentialRepository.save(userCredential);

            GenerateOtpCodeDto generatedOtp = this.otpService.getOtp();
            System.out.println("This is the generatedOtp =============> " + generatedOtp.toString());
            var otpDetails = OtpSetting.builder().userCredential(savedCred).otp(generatedOtp.getOtpCode()).expiry_date_time(generatedOtp.getExpiryTime()).build();
            otpSettingRepository.save(otpDetails);
//            emailService.sendHtmlEmail(generatedOtp.getOtpCode(), request.getEmail());
            return SignupResponse.builder().message("Successfully Cretaed user").build();
        }
        throw new BadRequestException("User with the email " + request.getEmail() + " already exists");
    }


    private boolean isNewUser(String email){
        return userDetailsRepository.existsByEmail(email);
    }
}