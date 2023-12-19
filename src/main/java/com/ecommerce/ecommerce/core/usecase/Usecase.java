package com.ecommerce.ecommerce.core.usecase;

import com.ecommerce.ecommerce.common.Result;

import java.util.concurrent.CompletableFuture;

public interface Usecase <I extends UsecaseRequest, U extends UsecaseResponse>{
    CompletableFuture<Result<U>> execute (I request);
}
