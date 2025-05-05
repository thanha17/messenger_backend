package com.social.messenger.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {

    @Value("${twilio.account_sid}")
    private String accountSid;

    @Value("${twilio.auth_token}")
    private String authToken;

    @Value("${twilio.phone_number}")
    private String phoneNumber;

    public void init() {
        Twilio.init(accountSid, authToken);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
