package com.ecommerce.ecommerce.feature.vendor.controller;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.responseHandler.ResponseHandler;
import com.ecommerce.ecommerce.feature.vendor.requestDto.OnboardVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.usecase.VendorInfoUsecase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor
public class VendorController {

    private final VendorInfoUsecase vendorInfoUsecase;
    @PostMapping("/details")
    public ResponseEntity<Object>registerVendor(@Valid @RequestBody OnboardVendorRequestDto request) throws BadRequestException {
        return ResponseHandler.responseBuilder("Successfully created vendor", HttpStatus.OK,vendorInfoUsecase.onboard(request));
    }
}
