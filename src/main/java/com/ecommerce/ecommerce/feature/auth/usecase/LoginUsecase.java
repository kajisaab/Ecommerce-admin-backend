package com.ecommerce.ecommerce.feature.auth.usecase;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.jwt.JwtService;
import com.ecommerce.ecommerce.core.validation.ValidationUtils;
import com.ecommerce.ecommerce.feature.auth.entity.User;
import com.ecommerce.ecommerce.feature.auth.entity.UserCredential;
import com.ecommerce.ecommerce.feature.auth.enumConstant.RoleEnum;
import com.ecommerce.ecommerce.feature.auth.requestDto.SigninUsecaseRequestDto;
import com.ecommerce.ecommerce.feature.auth.responseDto.SigninResponse;
import com.ecommerce.ecommerce.feature.auth.repository.UserCredentialRepository;
import com.ecommerce.ecommerce.feature.auth.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class LoginUsecase {
    private final UserDetailsRepository userDetailsRepository;
    private final UserCredentialRepository userCredentialRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(LoginUsecase.class);

    public SigninResponse authenticate(@RequestBody SigninUsecaseRequestDto request) {
        String violations = ValidationUtils.validate(request);
        if(!Objects.isNull(violations)){
            throw new BadRequestException(violations);
        }
        Optional<User> userDetails = userDetailsRepository.findByEmail(request.getEmail());

        AtomicReference<String> jwtToken = new AtomicReference<>("");
        String userDefinedRole;

        if (userDetails.isPresent()) {
            User user = userDetails.get();

            userDefinedRole = user.getRole().getDisplayName();


            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                throw new BadRequestException("Invalid Credentials ");
            }

            if(!user.isActive()){
                throw new BadRequestException("User is disabled");
            }

            jwtToken.set(jwtService.generateToken(user));

        } else {
            throw new BadRequestException("Cannot find the user with " + request.getEmail() + " email");
        }

        return SigninResponse.builder().token(jwtToken.get()).role(userDefinedRole).build();
    }
}
