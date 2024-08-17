package com.example.demo.security.service;

import com.example.demo.security.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(User userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

    ResponseCookie generateJwtCookie(String jwt);

    String getJwtFromCookies(HttpServletRequest request);

    ResponseCookie getCleanJwtCookie();
}
