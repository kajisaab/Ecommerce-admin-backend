package com.ecommerce.ecommerce.feature.auth.requestDto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class SignupUsecaseRequestDto {

    @NotNull
    @NotBlank(message = "First Name cannot be empty")
    private String firstName;

    @NotNull
    @NotBlank(message = "Last Name cannot be empty")
    private String lastName;

    @NotNull
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotNull
    @Min(value = 8, message = "Password must is 8 character short")
    @Max(value = 10, message = "Password cannot be long above 10 character")
    private String password;

    @NotNull
    private String userName;
}
