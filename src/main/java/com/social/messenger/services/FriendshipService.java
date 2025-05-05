package com.social.messenger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.messenger.models.Friendship;
import com.social.messenger.repositories.FriendshipRepository;

@Service
public class FriendshipService {
    @Autowired
    private FriendshipRepository friendshipRepository;

    // Gửi yêu cầu kết bạn
    public String sendFriendRequest(String user1Id, String user2Id) {
        if (friendshipRepository.findByUser1IdAndUser2Id(user1Id, user2Id) != null) {
            return "You are already friends or request pending";
        }
        Friendship friendship = new Friendship(user1Id, user2Id, "pending");
        friendshipRepository.save(friendship);
        return "Friend request sent";
    }

    // Chấp nhận yêu cầu kết bạn
    public String acceptFriendRequest(String user1Id, String user2Id) {
        Friendship friendship = friendshipRepository.findByUser1IdAndUser2Id(user1Id, user2Id);
        if (friendship != null && friendship.getStatus().equals("pending")) {
            friendship.setStatus("accepted");
            friendshipRepository.save(friendship);
            return "Friend request accepted";
        }
        return "Friend request not found";
    }

    // Kiểm tra trạng thái kết bạn
    public boolean isFriends(String user1Id, String user2Id) {
        Friendship friendship = friendshipRepository.findByUser1IdAndUser2Id(user1Id, user2Id);
        return friendship != null && friendship.getStatus().equals("accepted");
    }
}
