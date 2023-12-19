package com.ecommerce.ecommerce.core.expception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> resourceNotFoundExceptionHandler(BadRequestException e){
        int badRequest = HttpStatus.BAD_REQUEST.value();
        Object responseMessageObject = new GenerateMessageObject(e.getMessage());
        ApiException apiException = new ApiException(
                badRequest,
                HttpStatus.BAD_REQUEST,
                responseMessageObject
        );

        return new ResponseEntity<>(apiException, HttpStatusCode.valueOf(badRequest));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException e){
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    @ExceptionHandler(value = {IllegalStateException.class})
    public ResponseEntity<Object> handleInternalServerError(IllegalStateException e){
        Object responseMessageObject = new GenerateMessageObject(e.getMessage());
        int internalServerError = HttpStatus.INTERNAL_SERVER_ERROR.value();
        ApiException apiException = new ApiException(
                internalServerError,
                HttpStatus.INTERNAL_SERVER_ERROR,
                responseMessageObject
        );
        return new ResponseEntity<>(apiException, HttpStatusCode.valueOf(internalServerError));
    }
}
