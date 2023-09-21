package com.be.controller.socket;

import com.be.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    SimpMessagingTemplate simpMessagingTemplate;
    public ChatController(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/chatroom")
    @SendTo("/chatroom/messages")
    public Message send( Message message){
        return message;
    }

    @MessageMapping("/private/{userId}")
    @SendTo("/private/{userId}")
    public Message privateMessage(Message message) {
        return message;
    }

}
