package com.facebook.media.service;

import com.facebook.media.dto.LoginDto;
import com.facebook.media.request.SignUpRequest;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(SignUpRequest signUpRequest);
}
