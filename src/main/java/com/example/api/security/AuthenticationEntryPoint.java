package com.example.api.security;

import com.example.api.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getOutputStream().println(new ExceptionResponse(authException.getMessage(), HttpStatus.UNAUTHORIZED, LocalDateTime.now()).toString());
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("o7planning");
        super.afterPropertiesSet();
    }
}
