package com.example.Evaluations.evaluation.services;


import com.example.Evaluations.evaluation.model.Content;
import com.example.Evaluations.evaluation.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements INotificationService {

    @Autowired
    private Content content;

    @Override
    public Notification sendNotification(String sender, String recipient) {
        return null;
    }
}
