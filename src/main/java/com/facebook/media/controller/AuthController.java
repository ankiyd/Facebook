package com.facebook.media.controller;

import com.facebook.media.dto.LoginDto;
import com.facebook.media.request.SignUpRequest;
import com.facebook.media.response.JWTAuthResponse;
import com.facebook.media.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping(value = {"/login", "/signIn"})

    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping(value = {"/register", "/signUp"})
    public String register(@RequestBody SignUpRequest signUpRequest){
        String response = authService.register(signUpRequest);
        return response;
    }
}
