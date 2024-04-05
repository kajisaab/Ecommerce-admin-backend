package com.ecommerce.ecommerce.feature.auth.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SigninResponse {
    public String token;
    public String role;
    public List<String> permission;
}
