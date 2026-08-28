package com.codewithmosh.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("SMS")
@Primary
public class SmsNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("SmsNotification : " + message);
    }
}
