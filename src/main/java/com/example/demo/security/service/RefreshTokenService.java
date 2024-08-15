package com.example.demo.security.service;

import com.example.demo.security.entity.RefreshToken;
import com.example.demo.security.payload.request.RefreshTokenRequest;
import com.example.demo.security.payload.response.RefreshTokenResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseCookie;

import java.util.Optional;

public interface RefreshTokenService {

    RefreshToken createRefreshToken(Long userId);

    RefreshToken verifyExpiration(RefreshToken token);

    Optional<RefreshToken> findByToken(String token);

    RefreshTokenResponse generateNewToken(RefreshTokenRequest request);

    ResponseCookie generateRefreshTokenCookie(String token);

    String getRefreshTokenFromCookies(HttpServletRequest request);

    void deleteByToken(String token);

    ResponseCookie getCleanRefreshTokenCookie();
}
