package com.example.Evaluations.evaluation.services;

import com.example.Evaluations.evaluation.model.Content;
import com.example.Evaluations.evaluation.model.Notification;
import com.example.Evaluations.evaluation.model.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements INotificationService {

    @Autowired
    private Content content;

    @Override
    public Notification sendNotification(String sender, String recipient) {
        Notification notification = new Notification();
        notification.setMessage(content.getMessage());
        notification.setSender(sender);
        notification.setRecipient(recipient);
        notification.setNotificationType(NotificationType.SMS);
        return notification;
    }
}
