package com.social.messenger.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.messenger.models.User;
import com.social.messenger.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/search/findUser")
    public ResponseEntity<List<User>> findUsers(@RequestParam("query") String query) {
        List<User> users = userService.findUsersByQuery(query);
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable("id") String id) {
        userService.deleteAccount(id);
        return "User deleted successfully!";
    }

    @PutMapping("/{id}")
    public User updateProfile(@PathVariable("id") String id, @RequestBody User user) {
        return userService.updateProfile(id, user);
    }
    @PutMapping("/online/{userId}")
    public ResponseEntity<?> setOnline(@PathVariable String userId) {
        userService.setUserOnline(userId);
        return ResponseEntity.ok("User is now online.");
    }

    @PutMapping("/offline/{userId}")
    public ResponseEntity<?> setOffline(@PathVariable String userId) {
        userService.setUserOffline(userId);
        return ResponseEntity.ok("User is now offline.");
    }

}
