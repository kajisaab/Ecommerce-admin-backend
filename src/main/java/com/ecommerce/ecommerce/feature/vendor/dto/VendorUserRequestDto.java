package com.ecommerce.ecommerce.feature.vendor.dto;

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
public class VendorUserRequestDto {

    @NotNull(message = "First name cannot be null")
    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @NotNull(message = "Last Name cannot be null")
    @NotBlank(message = "Last Name cannot be empty")
    private String lastName;

    private String wardNo;

    @NotNull
    private String userName;

    @NotNull(message = "Contact Number cannot be null")
    @NotBlank(message = "Contact Number cannot be empty")
    private String contactNumber;

    @NotNull(message = "Country cannot be null")
    @NotBlank(message = "Country cannot be empty")
    private String country;

    @NotNull(message = "Province cannot be null")
    @NotBlank(message = "Province cannot be empty")
    private String province;

    @NotNull(message = "State cannot be null")
    @NotBlank(message = "State cannot be empty")
    private String state;

    private String street;

    private String municipality;

    private String ruralMunicipality;

    private String zipCode;
}
