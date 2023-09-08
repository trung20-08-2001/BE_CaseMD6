package com.be.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Bill bill;
    @ManyToOne
    private Service service;
}
