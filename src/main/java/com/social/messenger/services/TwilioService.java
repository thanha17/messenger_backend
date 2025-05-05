package com.social.messenger.services;

import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.video.v1.Room;
import com.twilio.rest.video.v1.room.Participant;
import com.twilio.type.PhoneNumber;
import com.twilio.type.Twiml;
import com.social.messenger.config.TwilioConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwilioService {

    private final TwilioConfig twilioConfig;

    // Gửi tin nhắn SMS
    public Message sendSms(String toPhoneNumber, String messageBody) {
        return Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(twilioConfig.getPhoneNumber()),
                messageBody
        ).create();
    }

    // Gọi điện thoại
    public Call makeVoiceCall(String toPhoneNumber, String url) {
        return Call.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(twilioConfig.getPhoneNumber()),
                new Twiml("<Response><Play>" + url + "</Play></Response>")
        ).create();
    }

    // Tạo phòng video
    public Room createVideoRoom(String roomName) {
    	twilioConfig.init();
        return Room.creator()
                .setUniqueName(roomName)
                .create();
    }

    // Thêm người vào phòng video
//    public Participant addParticipantToRoom(String roomSid, String identity) {
//        return Participant.creator(roomSid, identity)
//                .create();
//    }
}
