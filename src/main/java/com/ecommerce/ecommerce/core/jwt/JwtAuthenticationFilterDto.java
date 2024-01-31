package com.ecommerce.ecommerce.core.jwt;

import com.ecommerce.ecommerce.feature.auth.enumConstant.RoleEnum;
import com.ecommerce.ecommerce.feature.auth.enumConstant.UserTypeEnum;
import lombok.Data;

@Data
public class JwtAuthenticationFilterDto {

    public String userName;

    public String password;
    
    
}
