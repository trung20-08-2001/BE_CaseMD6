package com.be.service;

import com.be.model.Account;
import com.be.model.Message;

import java.util.List;

public interface IMessageService {
    List<Message>  findMessagesByReceiverAndSender(int idReceiver,int idSender);

    Message save(Message message);

    List<Account> findAccountsUserMessageToAccountHost(int idAccountHost);
}
