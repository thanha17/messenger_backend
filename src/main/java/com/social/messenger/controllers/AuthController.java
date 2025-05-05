package com.social.messenger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.messenger.models.User;
import com.social.messenger.services.AuthService;

// Controller nhận yêu cầu từ client
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // API đăng ký
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    // API đăng nhập
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return authService.login(user.getEmail(), user.getPassword());
    }
}
