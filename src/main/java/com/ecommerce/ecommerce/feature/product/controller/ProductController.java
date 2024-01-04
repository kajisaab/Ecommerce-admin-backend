package com.ecommerce.ecommerce.feature.product.controller;

import com.ecommerce.ecommerce.core.responseHandler.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {
    @GetMapping("/save")
    public ResponseEntity<Object>save(){
        return ResponseHandler.responseBuilder("Saved", HttpStatus.OK, "abc");
    }
}
