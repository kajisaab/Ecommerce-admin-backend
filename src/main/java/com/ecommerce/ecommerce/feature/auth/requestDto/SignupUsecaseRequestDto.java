package com.ecommerce.ecommerce.feature.auth.requestDto;

import jakarta.validation.constraints.*;
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
    @Size(min = 8, max = 10, message = "Password must be in between 8 to 10")
    private String password;

    @NotNull
    private String userName;

    @NotNull(message = "Phone Number cannot be null")
    @NotBlank(message = "Phone Number cannot be empty")
    @Size(min = 10, max = 10, message = "Phone Number must be of 10 digit")
    private String phoneNumber;
}
