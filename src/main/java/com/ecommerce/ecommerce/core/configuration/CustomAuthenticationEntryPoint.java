package com.ecommerce.ecommerce.core.configuration;

import com.ecommerce.ecommerce.core.expception.ApiException;
import com.ecommerce.ecommerce.core.expception.GenerateMessageObject;
import com.ecommerce.ecommerce.ssr.login.loginController.LoginController;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import static java.rmi.server.LogStream.log;

@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        final Logger logger = LoggerFactory.getLogger(LoginController.class);
        {
            // Customize the response for unauthorized access
            logger.debug("This is the auth Exception " + authException.getMessage());

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            GenerateMessageObject message = new GenerateMessageObject("User don't have permission to access this url");

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("data", message);


            try (OutputStream out = response.getOutputStream()) {
                ApiException apiException = new ApiException(401, HttpStatus.BAD_REQUEST, responseBody.get("data"));
                objectMapper.writeValue(out, apiException);
                out.flush();
            }
        }
    }


}