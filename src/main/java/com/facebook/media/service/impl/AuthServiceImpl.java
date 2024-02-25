package com.facebook.media.service.impl;

import com.facebook.media.entity.User;
import com.facebook.media.repository.UserRepository;
import com.facebook.media.request.SignUpRequest;
import com.facebook.media.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserRepository userRepository;
    @Override
    public String login(String username, String password) {
        return null;
    }
    @Override
    public String register(SignUpRequest signUpRequest) {
        if (userRepository.findByEmail(signUpRequest.getEmail()).isPresent()){
            return "Email already Registered!";
        }
        if(userRepository.findByUsername(signUpRequest.getUsername()).isPresent()){
            return "Username already exist!";
        }

        User user = User.createUserFromSignUpRequest(signUpRequest);
        userRepository.saveUser(user);
        return "Account Registered Successfully!";

    }

}
