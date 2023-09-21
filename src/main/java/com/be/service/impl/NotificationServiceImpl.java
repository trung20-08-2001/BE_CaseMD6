package com.be.service.impl;

import com.be.model.Notification;
import com.be.repository.INotificationRepository;
import com.be.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements INotificationService {
    @Autowired
    INotificationRepository iNotificationRepository;

    @Override
    public List<Notification> findByIdAccount(int idAccount) {
        return iNotificationRepository.findByIdAccount(idAccount);
    }

    @Override
    public List<Notification> updateStatus(List<Notification> notifications) {
        for (Notification notification : notifications) {
            if (!notification.isSeen()) {
                notification.setSeen(true);
            }
        }
        return iNotificationRepository.saveAll(notifications);
    }


    @Override
    public Notification save(Notification notification) {
        return iNotificationRepository.save(notification);
    }
}
