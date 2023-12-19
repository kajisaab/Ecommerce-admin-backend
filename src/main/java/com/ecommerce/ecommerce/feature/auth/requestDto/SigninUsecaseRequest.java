package com.ecommerce.ecommerce.feature.auth.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SigninUsecaseRequest  {

    @NotNull
    private String email;

    @NotNull
    private String password;
}
