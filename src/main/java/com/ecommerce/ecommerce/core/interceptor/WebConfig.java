package com.ecommerce.ecommerce.core.interceptor;

import com.ecommerce.ecommerce.core.jwt.CustomUserDetailsService;
import com.ecommerce.ecommerce.core.jwt.JwtService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    public WebConfig(JwtService jwtService, CustomUserDetailsService customUserDetailsService) {
        this.jwtService = jwtService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new AuthHandlerInterceptor(this.jwtService, this.customUserDetailsService));
    }
}
