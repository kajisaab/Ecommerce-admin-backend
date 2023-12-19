package com.ecommerce.ecommerce.feature.auth.usecase;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.jwt.JwtService;
import com.ecommerce.ecommerce.feature.auth.entity.User;
import com.ecommerce.ecommerce.feature.auth.entity.UserCredential;
import com.ecommerce.ecommerce.feature.auth.requestDto.SigninUsecaseRequest;
import com.ecommerce.ecommerce.feature.auth.responseDto.SigninResponse;
import com.ecommerce.ecommerce.feature.auth.repository.UserCredentialRepository;
import com.ecommerce.ecommerce.feature.auth.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;

@Service
@RequiredArgsConstructor
public class LoginUsecase {
    private final UserDetailsRepository userDetailsRepository;
    private final UserCredentialRepository userCredentialRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(LoginUsecase.class);

    public SigninResponse authenticate(SigninUsecaseRequest request) {
        Optional<User> userDetails = userDetailsRepository.findByEmail(request.getEmail());
        AtomicReference<String> jwtToken = new AtomicReference<>("");

        if (userDetails.isPresent()) {
            User user = userDetails.get();
            String userId = user.getId();

            List<UserCredential> userCredentialDetails = userCredentialRepository.findByUserId(userId);

            UserCredential userCredential = null;

            if (!userCredentialDetails.isEmpty()) {
                userCredential = userCredentialDetails.get(0);
            }

            if (userCredential != null && !passwordEncoder.matches(request.getPassword(), userCredential.getPassword())) {
                throw new BadRequestException("Invalid Credentials ");
            }

            if(userCredential !=null && !user.is_active()){
                throw new BadRequestException("User is disabled");
            }

            jwtToken.set(jwtService.generateToken(user));

        } else {
            throw new BadRequestException("Cannot find the user with " + request.getEmail() + " email");
        }

        return SigninResponse.builder().token(jwtToken.get()).build();
    }
}
