package com.ecommerce.ecommerce.core.responseHandler;

import com.ecommerce.ecommerce.core.responseHandler.service.ResponseHandlerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject){
        ResponseHandlerService response = new ResponseHandlerService(httpStatus.value(), message, responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }
}
