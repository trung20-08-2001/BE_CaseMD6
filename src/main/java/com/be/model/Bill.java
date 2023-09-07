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
    @Column(columnDefinition = "double default 0")
    private double totalPrice;
    @ManyToOne
    private Account user;
    @ManyToOne
    private Account vendor;
    @ManyToOne
    private Status status;
    @ManyToOne
    private House house;
}