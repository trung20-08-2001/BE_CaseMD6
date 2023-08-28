package com.be.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date dateCheckin;
    private Date dateCheckout;
    private double totalPrice;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Status status;
}