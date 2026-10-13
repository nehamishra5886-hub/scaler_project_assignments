package com.example.Evaluations.evaluation.services;

import com.example.Evaluations.evaluation.model.Notification;

public interface INotificationService {

    Notification sendNotification(String sender, String recipient);
}
