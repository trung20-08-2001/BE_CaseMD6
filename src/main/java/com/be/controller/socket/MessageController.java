package com.be.controller.socket;

import com.be.model.Account;
import com.be.model.Message;
import com.be.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    IMessageService iMessageService;

    @GetMapping("findMessageByReceiverAccountAndSenderAccount/{idReceiverAccount}/{idSenderAccount}")
    public List<Message> findMessageByReceiverAccountAndSenderAccount(@PathVariable int idReceiverAccount, @PathVariable int idSenderAccount){
        return iMessageService.findMessagesByReceiverAndSender(idReceiverAccount,idSenderAccount);
    }

    @PostMapping("/save")
    private Message save(@RequestBody Message message){
      return   iMessageService.save(message);
    }


}