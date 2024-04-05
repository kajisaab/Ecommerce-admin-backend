package com.ecommerce.ecommerce.feature.product.controller;

import com.ecommerce.ecommerce.core.expception.BadRequestException;
import com.ecommerce.ecommerce.core.responseHandler.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {

    @PostMapping("/add-product-category")
    public ResponseEntity<Object>addCategory() throws BadRequestException {return ResponseHandler.responseBuilder("Added Category", HttpStatus.OK, "added category");}

    @GetMapping("/save")
    public ResponseEntity<Object>save(){
        return ResponseHandler.responseBuilder("Saved", HttpStatus.OK, "abc");
    }
}
