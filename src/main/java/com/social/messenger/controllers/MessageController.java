package com.social.messenger.controllers;

import com.social.messenger.models.Message;
import com.social.messenger.models.MessageStatus;
import com.social.messenger.services.MessageService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    @PostMapping("/conversation")
    public ResponseEntity<List<Message>> getConversation(@RequestBody Map<String, String> request) {
    	String user1Id = request.get("user1Id");
        String user2Id = request.get("user2Id");

        List<Message> messages = messageService.getMessagesBetweenUsers(user1Id, user2Id);
        return ResponseEntity.ok(messages);
    }
    
    //set trạng thái tin nhắn
    @PutMapping("/update-status/{messageId}")
    public ResponseEntity<?> updateMessageStatus(
            @PathVariable String messageId,
            @RequestParam MessageStatus status) {
        messageService.updateMessageStatus(messageId, status);
        return ResponseEntity.ok("Message status updated to " + status);
    }
}
