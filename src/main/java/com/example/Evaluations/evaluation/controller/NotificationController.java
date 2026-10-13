package com.example.Evaluations.evaluation.controller;

import com.example.Evaluations.evaluation.dtos.NotificationRequestDto;
import com.example.Evaluations.evaluation.model.Notification;
import com.example.Evaluations.evaluation.services.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private INotificationService notificationService;

    @PostMapping("/notification")
    public Notification sendNotification(@RequestBody NotificationRequestDto notificationRequest) {
        return notificationService.sendNotification(notificationRequest.getSender(),notificationRequest.getRecipient());
    }
}
