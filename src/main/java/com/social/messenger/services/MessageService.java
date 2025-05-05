package com.social.messenger.services;

import com.social.messenger.models.Message;
import com.social.messenger.models.MessageStatus;
import com.social.messenger.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message sendMessage(Message message) {
        message.setTimestamp(LocalDateTime.now()); // tự động gán thời gian gửi
        message.setStatus(MessageStatus.SENT);      // gán luôn trạng thái SENT
        return messageRepository.save(message);
    }

    public List<Message> getMessagesBetweenUsers(String userId1, String userId2) {
        return messageRepository.findBySenderIdAndReceiverIdOrReceiverIdAndSenderId(userId1, userId2, userId1, userId2);
    }

    //set trạng thái tin nhắn
    public void updateMessageStatus(String messageId, MessageStatus status) {
        messageRepository.findById(messageId).ifPresent(message -> {
            message.setStatus(status);
            messageRepository.save(message);
        });
    }
}
