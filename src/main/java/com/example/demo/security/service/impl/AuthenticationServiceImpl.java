package com.example.demo.security.service.impl;

import com.example.demo.security.entity.User;
import com.example.demo.security.enums.Role;
import com.example.demo.security.enums.TokenType;
import com.example.demo.security.payload.request.AuthenticationRequest;
import com.example.demo.security.payload.request.RegisterRequest;
import com.example.demo.security.payload.response.AuthenticationResponse;
import com.example.demo.security.repository.UserRepository;
import com.example.demo.security.service.AuthenticationService;
import com.example.demo.security.service.JwtService;
import com.example.demo.security.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service @Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;


    @Override
    public AuthenticationResponse register(RegisterRequest request) {

        String email = request.getEmail();
        User userExist = userRepository.findByEmail(email).orElse(null);
        if (userExist != null){
            return AuthenticationResponse.builder()
                    .accessToken(null)
                    .email(request.getEmail())
                    .id(null)
                    .refreshToken(null)
                    .roles(null)
                    .tokenType(null)
                    .message("User with email "+request.getEmail()+" already exists")
                    .status("Failure")
                    .build();
        }


        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        var savedUser = userRepository.save(user);

        var jwt = jwtService.generateToken(savedUser);
        var refreshToken = refreshTokenService.createRefreshToken(savedUser.getId());

        var roles = savedUser.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();

        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .email(savedUser.getEmail())
                .id(savedUser.getId())
                .refreshToken(refreshToken.getToken())
                .roles(roles)
                .tokenType( TokenType.BEARER.name())
                .message("User created")
                .status("Success")
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();
        var jwt = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user.getId());
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .roles(roles)
                .email(user.getEmail())
                .id(user.getId())
                .refreshToken(refreshToken.getToken())
                .tokenType( TokenType.BEARER.name())
                .message("User connected")
                .status("Success")
                .build();
    }
}