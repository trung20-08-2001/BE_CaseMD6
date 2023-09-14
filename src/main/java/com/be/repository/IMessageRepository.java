package com.be.repository;

import com.be.model.Account;
import com.be.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMessageRepository extends JpaRepository<Message,Integer> {
    @Query(value = "select m from Message m where (m.receiverAccount.id=:idReceiverAccount and m.senderAccount.id=:idSenderAccount) or(m.receiverAccount.id=:idSenderAccount and m.senderAccount.id=:idReceiverAccount)  order by m.id")
    List<Message> findMessageByReceiverAccountAndSenderAccount(@Param("idReceiverAccount") int idReceiverAccount, @Param("idSenderAccount")int idSenderAccount);

    @Query(value = "select distinct m.receiverAccount,m.senderAccount  from Message m where m.senderAccount.id=:idAccountHost or m.receiverAccount.id=:idAccountHost")
    List<Account> findAccountsUserMessageToAccountHost(@Param("idAccountHost") int idAccountHost);

//@Query(nativeQuery = true,value = "select distinct * from (select * from message where message.receiver_account_id=:id or message.sender_account_id:id) where m")
//    List<Account> findAccountsUserMessageToAccountHost(@Param("idAccountHost") int idAccountHost);

}
