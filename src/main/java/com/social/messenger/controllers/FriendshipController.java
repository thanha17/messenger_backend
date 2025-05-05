package com.social.messenger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.social.messenger.services.FriendshipService;

@RestController
@RequestMapping("/friendship")
public class FriendshipController {
    @Autowired
    private FriendshipService friendshipService;

    @PostMapping("/sendRequest")
    public String sendFriendRequest(@RequestBody Map<String, String> request) {
        String user1Id = request.get("user1Id");
        String user2Id = request.get("user2Id");
        return friendshipService.sendFriendRequest(user1Id, user2Id);
    }

    @PostMapping("/acceptRequest")
    public String acceptFriendRequest(@RequestBody Map<String, String> request) {
        String user1Id = request.get("user1Id");
        String user2Id = request.get("user2Id");
        return friendshipService.acceptFriendRequest(user1Id, user2Id);
    }

    @GetMapping("/isFriends")
    public boolean isFriends(@RequestParam("user1Id") String user1Id, @RequestParam("user2Id") String user2Id) {
        return friendshipService.isFriends(user1Id, user2Id);
    }
}
