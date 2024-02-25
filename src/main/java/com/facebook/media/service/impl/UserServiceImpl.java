package com.facebook.media.service.impl;

import com.facebook.media.entity.User;
import com.facebook.media.repository.UserRepository;
import com.facebook.media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public String saveUser(User user) {
        userRepository.saveUser(user);
        return "User saved successfully!";
    }

    @Override
    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } throw new RuntimeException("User Not Found");
    }

}
