package com.facebook.media.service;

import com.facebook.media.request.SignUpRequest;

public interface AuthService {

    String login(String username, String password);
    String register(SignUpRequest signUpRequest);
}
