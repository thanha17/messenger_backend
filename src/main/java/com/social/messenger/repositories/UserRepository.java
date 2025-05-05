package com.social.messenger.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.social.messenger.models.User;

// Repository làm việc với MongoDB
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    List<User> findByUsernameContainingIgnoreCase(String username);
}
