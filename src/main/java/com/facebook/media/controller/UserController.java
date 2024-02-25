package com.facebook.media.controller;

import com.facebook.media.entity.User;
import com.facebook.media.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/search/{userId}")
    public User searchUserByUserId(@RequestPart(value = "id") String userId){
        return userService.findByUserId(userId);
    }

    @GetMapping("/search/username")
    public User searchUserByUsername(@RequestPart(value = "id") String username){
        return userService.findByUsername(username);
    }
}
