package com.facebook.media.service.impl;

import com.facebook.media.dto.LoginDto;
import com.facebook.media.entity.User;
import com.facebook.media.repository.UserRepository;
import com.facebook.media.request.SignUpRequest;
import com.facebook.media.security.JwtTokenProvider;
import com.facebook.media.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }
    @Override
    public String register(SignUpRequest signUpRequest) {
        if (userRepository.findByEmail(signUpRequest.getEmail()).isPresent()){
            return "Email already Registered!";
        }
        if(userRepository.findByUsername(signUpRequest.getUsername()).isPresent()){
            return "Username already exist!";
        }

        User user = User.createUserFromSignUpRequest(signUpRequest, passwordEncoder);
        userRepository.saveUser(user);
        return "Account Registered Successfully!";

    }

}
