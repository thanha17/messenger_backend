package com.social.messenger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.messenger.models.User;
import com.social.messenger.repositories.UserRepository;

// Service xử lý nghiệp vụ đăng ký, đăng nhập
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Đăng ký
    public User register(User user) {
        return userRepository.save(user);
    }

    // Đăng nhập
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
