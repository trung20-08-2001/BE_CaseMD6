package com.be.controller.user;

import com.be.model.Notification;
import com.be.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    INotificationService iNotificationService;
    @GetMapping("/findByIdAccount/{idAccount}")
    public List<Notification> findByIdAccount(@PathVariable int idAccount){
        return iNotificationService.findByIdAccount(idAccount);
    }

    @PostMapping("/updateStatus")
    public List<Notification> updateStatus(@RequestBody List<Notification> notifications){
        return iNotificationService.updateStatus(notifications);
    }
    @PostMapping("/save")
    public Notification save(@RequestBody Notification notification){
       return iNotificationService.save(notification);
    }
}
