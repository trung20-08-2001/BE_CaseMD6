package com.be.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Account  senderAccount;
    @ManyToOne
    private Account receiverAccount;
    private String message;
    private Date date;
}
