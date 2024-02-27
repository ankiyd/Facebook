package com.facebook.media.repository;

import com.facebook.media.entity.User;

import java.util.Optional;

public interface UserRepository {

     void saveUser(User user);
     User findByUserId(String userId);
     Optional<User> findByUsername(String username);
     Optional<User> findByEmail(String email);
     Optional<User> findByUsernameOrEmail(String username, String email);
}
