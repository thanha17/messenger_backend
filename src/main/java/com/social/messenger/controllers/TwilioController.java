package com.social.messenger.controllers;

import com.social.messenger.services.TwilioService;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.video.v1.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/twilio")
public class TwilioController {

    private final TwilioService twilioService;

    @Autowired
    public TwilioController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    // Gửi tin nhắn SMS
    @PostMapping("/send-sms")
    public Message sendSms(@RequestParam String toPhoneNumber, @RequestParam String messageBody) {
        return twilioService.sendSms(toPhoneNumber, messageBody);
    }

    // Gọi thoại
    @PostMapping("/make-call")
    public Call makeCall(@RequestParam String toPhoneNumber, @RequestParam String url) {
        return twilioService.makeVoiceCall(toPhoneNumber, url);
    }

    // Tạo phòng video
    @PostMapping("/create-room")
    public Room createRoom(@RequestParam("roomName") String roomName) {
        return twilioService.createVideoRoom(roomName);
    }
}
