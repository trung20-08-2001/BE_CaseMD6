package com.be.model.dto;

import com.be.model.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    private Notification notification;
    private int numberOfNotificationsNotSeen;

}
