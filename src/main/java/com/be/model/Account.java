package com.be.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String phone;
    private String address;
    @Column(columnDefinition = "TEXT")
    private String avatar;
    @Column(columnDefinition = "TEXT")
    private String img1;
    @Column(columnDefinition = "TEXT")
    private String img2;
    @ManyToOne
    private Role role;
    @ManyToOne
    private Status status;

}
