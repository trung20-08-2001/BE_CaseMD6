package com.be.service.impl;

import com.be.model.Account;
import com.be.model.Message;
import com.be.repository.IMessageRepository;
import com.be.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    IMessageRepository iMessageRepository;
    @Override
    public List<Message> findMessagesByReceiverAndSender(int idReceiver, int idSender) {
        return iMessageRepository.findMessageByReceiverAccountAndSenderAccount(idReceiver,idSender);
    }



    @Override
    public void save(Message message) {
        iMessageRepository.save(message);
    }

    @Override
    public List<Account> findAccountsUserMessageToAccountHost(int idAccountHost) {
        return iMessageRepository.findAccountsUserMessageToAccountHost(idAccountHost);
    }
}
