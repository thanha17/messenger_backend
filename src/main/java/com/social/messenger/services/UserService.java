package com.social.messenger.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.social.messenger.models.User;
import com.social.messenger.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findUsersByQuery(String query) {
        return userRepository.findByUsernameContainingIgnoreCase(query);
    }
    public void deleteAccount(String userId) {
        userRepository.deleteById(userId);
    }

    public User updateProfile(String userId, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found with id: " + userId);
        }

        User existingUser = optionalUser.get();

        // Cập nhật từng field
        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setAvatarUrl(updatedUser.getAvatarUrl());
        existingUser.setGender(updatedUser.getGender());
        existingUser.setBio(updatedUser.getBio());

        return userRepository.save(existingUser);
    }
 // Đặt online (gọi sau khi login)
    public void setUserOnline(String userId) {
        userRepository.findById(userId).ifPresent(user -> {
            user.setOnline(true);
            user.setLastSeen(LocalDateTime.now());
            userRepository.save(user);
        });
    }

    // Đặt offline (gọi sau khi logout)
    public void setUserOffline(String userId) {
        userRepository.findById(userId).ifPresent(user -> {
            user.setOnline(false);
            user.setLastSeen(LocalDateTime.now());
            userRepository.save(user);
        });
    }
}
