package com.ecommerce.ecommerce.feature.vendor.controller;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.responseHandler.ResponseHandler;
import com.ecommerce.ecommerce.feature.vendor.requestDto.OnboardVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.requestDto.UpdateVendorRequestDto;
import com.ecommerce.ecommerce.feature.vendor.requestDto.VendorListRequestDto;
import com.ecommerce.ecommerce.feature.vendor.service.GetAllVendorListService;
import com.ecommerce.ecommerce.feature.vendor.service.GetIndividualVendorDetailService;
import com.ecommerce.ecommerce.feature.vendor.service.OnboardVendorService;
import com.ecommerce.ecommerce.feature.vendor.service.UpdateVendorDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor
public class VendorController {

    private final GetAllVendorListService getAllVendorListService;
    private final OnboardVendorService onboardVendorService;
    private final GetIndividualVendorDetailService getIndividualVendorDetailService;
    private final UpdateVendorDetailsService updateVendorDetailsService;

    @PostMapping("/list")
    public ResponseEntity<Object>getALlVendorList(@RequestBody VendorListRequestDto request

    ) throws BadRequestException {
        Pageable pageable = PageRequest.of(request.page, request.size);
        return ResponseHandler.responseBuilder("SUCCESS", HttpStatus.OK, getAllVendorListService.getAllVendroDetailsList(request.search, pageable));
    }

    @PostMapping("/save")
    public ResponseEntity<Object> onboardVendor(@Valid @RequestBody OnboardVendorRequestDto request) throws BadRequestException{
        return ResponseHandler.responseBuilder("SUCCESS", HttpStatus.OK, onboardVendorService.onboardVendor(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>getIndividualVendor(@PathVariable(value = "id") String id) throws BadRequestException{
        return ResponseHandler.responseBuilder("SUCCESS", HttpStatus.OK, getIndividualVendorDetailService.getVendorDetail(id));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Object>updateVendorDetails(@PathVariable(value = "id") String id, @RequestBody UpdateVendorRequestDto request) throws BadRequestException{
        return ResponseHandler.responseBuilder("SUCCESSFULLY UPDATED", HttpStatus.OK, updateVendorDetailsService.updateVendor(request, id));
    }
}
