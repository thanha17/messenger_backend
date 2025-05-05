package com.social.messenger.services;

import com.social.messenger.models.GroupMessage;
import com.social.messenger.repositories.GroupMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GroupMessageService {

    @Autowired
    private GroupMessageRepository groupMessageRepository;

    public GroupMessage sendMessage(GroupMessage groupMessage) {
        groupMessage.setTimestamp(LocalDateTime.now());
        return groupMessageRepository.save(groupMessage);
    }

    public List<GroupMessage> getMessagesByGroupId(String groupId) {
        return groupMessageRepository.findByGroupIdOrderByTimestampAsc(groupId);
    }
}
