package com.be.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ServiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private House house;
    @ManyToOne
    private Service service;
}
