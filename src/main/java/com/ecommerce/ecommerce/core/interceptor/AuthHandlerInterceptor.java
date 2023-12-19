package com.ecommerce.ecommerce.core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class AuthHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("This is the new response header", "Custom-Value");
        // Get a specific request header
        String customHeader = request.getHeader("Custom-Header");

        if (customHeader != null) {
            // Use the value of the custom header
            System.out.println("Custom-Header Value: " + customHeader);
        } else {
            System.out.println("Custom-Header is not present in the request.");
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
