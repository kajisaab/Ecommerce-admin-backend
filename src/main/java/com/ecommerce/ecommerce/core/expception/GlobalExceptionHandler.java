package com.ecommerce.ecommerce.core.expception;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.ServletException;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> badRequestExceptionHandler(BadRequestException e){
        int badRequest = HttpStatus.BAD_REQUEST.value();
        Object responseMessageObject = new GenerateMessageObject(e.getMessage());
        ApiException apiException = new ApiException(
                badRequest,
                HttpStatus.BAD_REQUEST,
                responseMessageObject
        );

        return new ResponseEntity<>(apiException, HttpStatusCode.valueOf(badRequest));
    }

    // Handles the jwt expiry exception
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


    @ExceptionHandler(value = {ExpiredJwtException.class})
    public ResponseEntity<Object> expiredExceptionHandler(ExpiredJwtException e){
        int badRequest = HttpStatus.UNAUTHORIZED.value();
        Object responseMessageObject = new GenerateMessageObject("Token Expired!");
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

    // Handles any IllegalArgument Exception and IllegalArgumentException is used in every Enum as well
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

    // Handles all the sql error
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

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<Object> handleInvalidJwtToken(MalformedJwtException e){
        Object responseMessageObject = new GenerateMessageObject(e.getMessage());
        int unauthorizedRequest = HttpStatus.UNAUTHORIZED.value();
        ApiException apiException = new ApiException(
                unauthorizedRequest,
                HttpStatus.UNAUTHORIZED,
                responseMessageObject
        );
        return new ResponseEntity<>(apiException, HttpStatusCode.valueOf(unauthorizedRequest));
    }

    @ExceptionHandler(ConverterNotFoundException.class)
    public ResponseEntity<Object> handleJpaConverterException(ConverterNotFoundException e){
        Object responseMessageObject = new GenerateMessageObject(e.getMessage());
        int unauthorizedRequest = HttpStatus.BAD_REQUEST.value();
        ApiException apiException = new ApiException(
                unauthorizedRequest,
                HttpStatus.BAD_REQUEST,
                responseMessageObject
        );
        return new ResponseEntity<>(apiException, HttpStatusCode.valueOf(unauthorizedRequest));
    }

}
