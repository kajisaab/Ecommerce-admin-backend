package com.ecommerce.ecommerce.feature.vendor.controller;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.responseHandler.ResponseHandler;
import com.ecommerce.ecommerce.feature.vendor.requestDto.OnboardVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.service.GetAllVendorList;
import com.ecommerce.ecommerce.feature.vendor.service.GetIndividualVendorDetail;
import com.ecommerce.ecommerce.feature.vendor.service.OnboardVendorService;
import com.ecommerce.ecommerce.feature.vendor.usecase.GetAllVendorListUsecase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor
public class VendorController {

    private final GetAllVendorList getAllVendorList;
    private final OnboardVendorService onboardVendorService;
    private final GetIndividualVendorDetail getIndividualVendorDetail;

    @GetMapping("/list")
    public ResponseEntity<Object>getALlVendorList() throws BadRequestException {
        return ResponseHandler.responseBuilder("SUCCESS", HttpStatus.OK,getAllVendorList.getAllVendroDetailsList());
    }

    @PostMapping("/save")
    public ResponseEntity<Object> onboardVendor(@Valid @RequestBody OnboardVendorRequestDto request) throws BadRequestException{
        return ResponseHandler.responseBuilder("SUCCESS", HttpStatus.OK, onboardVendorService.onboardVendor(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>getIndividualVendor(@PathVariable(value = "id") String id) throws BadRequestException{
        return ResponseHandler.responseBuilder("SUCCESS", HttpStatus.OK, getIndividualVendorDetail.getVendorDetail(id));
    }
}
