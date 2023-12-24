package com.ecommerce.ecommerce.feature.auth.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SigninUsecaseRequestDto {

    @NotNull
    @NotBlank(message = "email cannot be empty")
    private String email;

    @NotNull
    @NotBlank(message = "password cannot be empty")
    private String password;
}
