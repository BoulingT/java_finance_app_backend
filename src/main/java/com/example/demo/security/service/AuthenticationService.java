package com.example.demo.security.service;

import com.example.demo.security.payload.request.AuthenticationRequest;
import com.example.demo.security.payload.request.RegisterRequest;
import com.example.demo.security.payload.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
