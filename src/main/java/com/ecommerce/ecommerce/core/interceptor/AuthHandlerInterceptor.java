package com.ecommerce.ecommerce.core.interceptor;

import com.ecommerce.ecommerce.core.jwt.CustomUserDetailsService;
import com.ecommerce.ecommerce.core.jwt.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class AuthHandlerInterceptor implements HandlerInterceptor {
    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public AuthHandlerInterceptor(JwtService jwtService, CustomUserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String jwt;
        final String userEmail;
        final String authHeader  = request.getHeader("X-XSRF-TOKEN");
        AtomicReference<String> jwtToken = new AtomicReference<>("");
        if(authHeader != null) {
            jwt = authHeader;
            userEmail = jwtService.extractUserEmail(jwt); // todo extract the userEmail from JWT token;
            if(userEmail != null){
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
                if(jwtService.isTokenValid(jwt, userDetails)) {
                    jwtToken.set(jwtService.generateToken(userDetails));
                    response.setHeader("X-XSRF-TOKEN", jwtToken.get());
                }
            }
        }
        // update the token and send the token to the response from here.
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
