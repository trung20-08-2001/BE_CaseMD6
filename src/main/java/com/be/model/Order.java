package com.be.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date dateCheckin;
    private Date dateCheckout;
    private double price;
    @ManyToOne
    private Account account;
    @ManyToOne
    private House house;
    @ManyToOne
    private Status status;
}