package com.be.service;

import com.be.model.Notification;

import java.util.List;

public interface INotificationService {
    List<Notification> findByIdAccount(int idAccount);
    List<Notification> updateStatus(List<Notification> notifications);
    Notification save(Notification notification);
}
