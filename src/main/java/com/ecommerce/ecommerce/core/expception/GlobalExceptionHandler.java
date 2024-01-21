package com.ecommerce.ecommerce.core.expception;

import io.jsonwebtoken.ClaimJwtException;
import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLIntegrityConstraintViolationException;
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

    @ExceptionHandler(value = {ClaimJwtException.class})
    public ResponseEntity<Object> resourceNotFoundExceptionHandler(ClaimJwtException e){
        int badRequest = HttpStatus.UNAUTHORIZED.value();
        Object responseMessageObject = new GenerateMessageObject("Token invalid or Expired!");
        ApiException apiException = new ApiException(
                badRequest,
                HttpStatus.UNAUTHORIZED,
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

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e){
        Object responseMessageObject = new GenerateMessageObject(e.getMessage());
        int badRequest = HttpStatus.BAD_REQUEST.value();
        ApiException apiException = new ApiException(
                badRequest,
                HttpStatus.BAD_REQUEST,
                responseMessageObject
        );
        return new ResponseEntity<>(apiException, HttpStatusCode.valueOf(badRequest));
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleSQLException(SQLIntegrityConstraintViolationException e){
        Object responseMessageObject = new GenerateMessageObject(e.getMessage());
        int badRequest = HttpStatus.BAD_REQUEST.value();
        ApiException apiException = new ApiException(
                badRequest,
                HttpStatus.BAD_REQUEST,
                responseMessageObject
        );
        return new ResponseEntity<>(apiException, HttpStatusCode.valueOf(badRequest));
    }
}
