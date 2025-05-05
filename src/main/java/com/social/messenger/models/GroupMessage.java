package com.social.messenger.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "group_messages")
public class GroupMessage {
    @Id
    private String id;
    private String groupId;
    private String senderId;
    private String text; // nội dung text (có thể null)
    private String mediaUrl; // link ảnh hoặc video (nếu có)
    private String mediaType; // "image" hoặc "video"
    private LocalDateTime timestamp;
}
