package com.ecommerce.ecommerce.core.expception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiException {
    private final int status;
    private final HttpStatus error;
    private final Object data;

    public ApiException(int status, HttpStatus error, Object errorObject){
        this.status = status;
        this.error = error;
        this.data = errorObject;
    }
}
