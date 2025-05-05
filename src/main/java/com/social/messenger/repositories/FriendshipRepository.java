package com.social.messenger.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.social.messenger.models.Friendship;

public interface FriendshipRepository extends MongoRepository<Friendship, String> {
    List<Friendship> findByUser1IdAndStatus(String user1Id, String status);
    List<Friendship> findByUser2IdAndStatus(String user2Id, String status);
    Friendship findByUser1IdAndUser2Id(String user1Id, String user2Id);
}
