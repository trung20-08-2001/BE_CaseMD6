package com.be.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String phone;
    private String address;
    private String avatar;
    @ManyToOne
    private Role role;
    @ManyToOne
    private Status status;
}
