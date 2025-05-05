package com.social.messenger.controllers;

import com.social.messenger.models.GroupMessage;
import com.social.messenger.services.GroupMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group-messages")
public class GroupMessageController {

    @Autowired
    private GroupMessageService groupMessageService;

    @PostMapping
    public ResponseEntity<GroupMessage> sendMessage(@RequestBody GroupMessage groupMessage) {
        GroupMessage savedMessage = groupMessageService.sendMessage(groupMessage);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<List<GroupMessage>> getMessages(@PathVariable String groupId) {
        List<GroupMessage> messages = groupMessageService.getMessagesByGroupId(groupId);
        return ResponseEntity.ok(messages);
    }
}
