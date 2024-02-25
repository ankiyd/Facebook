package com.facebook.media.controller;

import com.facebook.media.request.SignUpRequest;
import com.facebook.media.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping(value = {"/login", "/signIn"})
    public String login(@PathVariable(name ="username") String username,
                        @PathVariable(name = "password") String password){
        return "Login successfully!";
    }

    @PostMapping(value = {"/register", "/signUp"})
    public String register(@RequestBody SignUpRequest signUpRequest){
        String response = authService.register(signUpRequest);
        return response;
    }
}
