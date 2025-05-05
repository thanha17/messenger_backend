package com.social.messenger.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    private String senderId;
    private String receiverId;
    private String text;
    private String fileUrl; // Đường dẫn file (ảnh hoặc video nếu có)
    private String fileType; // "image" hoặc "video"
    private LocalDateTime timestamp;
    private MessageStatus status;
}
