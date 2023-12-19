package com.ecommerce.ecommerce.common;

import java.util.List;

public class Result<T> {
    private String code;
    private String message;
    private T data;
    private List<Error> errors;

    public Result(String code, String message, T data, List<Error> errors){
        this.code = code;
        this.message = message;
        this.data = data;
        this.errors = errors;
    }

    public boolean isSuccess(){
        return errors == null || errors.isEmpty();
    }

    public static <T> Result<T> createSuccess(T data){
        return new Result<>("0", "SUCCESS", data, List.of());
    }

    public static <T> Result<T> createSuccessMessageWithMessage(T data, String message){
        return new Result<>("0", message, data, List.of());
    }


}
