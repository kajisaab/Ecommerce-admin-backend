package com.ecommerce.ecommerce.core.configuration;

import com.ecommerce.ecommerce.core.expception.ApiException;
import com.ecommerce.ecommerce.core.expception.GenerateMessageObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        {
            // Customize the response for unauthorized access
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            GenerateMessageObject message = new GenerateMessageObject("Unauthorized");

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("data", message);


            try (OutputStream out = response.getOutputStream()) {
                ApiException apiException = new ApiException(401, HttpStatus.UNAUTHORIZED, responseBody.get("data"));
                objectMapper.writeValue(out, apiException);
                out.flush();
            }
        }
    }


}