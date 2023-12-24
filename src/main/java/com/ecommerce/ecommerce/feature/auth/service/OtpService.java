package com.ecommerce.ecommerce.feature.auth.service;

import com.ecommerce.ecommerce.feature.auth.dto.GenerateOtpCodeDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
public class OtpService {

    private GenerateOtpCodeDto generateOtp(){
        Random random = new Random();

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String expiryTime = currentTime.format(formatter);

        int otpCode = random.nextInt((999999 - 100000) + 100000);
        return GenerateOtpCodeDto.builder().otpCode(otpCode).expiryTime(expiryTime).build();
    };

    private static boolean verifyOTP(String savedOTP, String savedTimestamp) {
        // Parse the saved timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime timestamp = LocalDateTime.parse(savedTimestamp, formatter);

        // Get the current timestamp
        LocalDateTime currentTime = LocalDateTime.now();

        // Calculate the time difference in minutes
        long minutesDifference = ChronoUnit.MINUTES.between(timestamp, currentTime);

        // Check if the OTP is valid and generated within the last 5 minutes
        return savedOTP.equals("123456") && minutesDifference <= 5;
    }

    public GenerateOtpCodeDto getOtp() {
        return this.generateOtp();
    };
}
