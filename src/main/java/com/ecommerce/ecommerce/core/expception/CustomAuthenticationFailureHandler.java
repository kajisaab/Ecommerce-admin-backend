package com.ecommerce.ecommerce.core.expception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // Handle the authentication failure exception here
        // You can log the exception or add custom logic

        System.out.println("This is the error " + exception.getMessage() );

        // For example, you can set an attribute with the error message
        request.setAttribute("error", "Authentication failed: " + exception.getMessage());

        // Redirect back to the login page with the error message
        response.sendRedirect("/login?error");
    }
}
