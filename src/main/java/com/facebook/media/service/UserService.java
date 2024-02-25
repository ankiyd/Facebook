package com.facebook.media.service;

import com.facebook.media.entity.User;

public interface UserService {

    String saveUser(User user);
    User findByUserId(String userId);

    User findByUsername(String username);
}
