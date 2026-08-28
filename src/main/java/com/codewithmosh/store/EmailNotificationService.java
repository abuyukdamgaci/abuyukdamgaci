package com.codewithmosh.store;

import org.springframework.stereotype.Service;

@Service("EMAIL")
public class EmailNotificationService implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("Email Notification : " + message);
    }
}
