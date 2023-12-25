package com.ecommerce.ecommerce.feature.vendor.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendroBankDetailsRequestDto {

    @NotNull(message = "Account name cannot be null")
    @NotBlank(message = "Account name cannot be empty")
    private String accountHolder;

    @NotNull(message = "Account number cannot be null")
    @NotBlank(message = "Account number cannot be empty")
    private String accountNumber;

    @NotNull(message = "Bank name cannot be null")
    @NotBlank(message = "Bank name cannot be empty")
    private String bankName;
}
