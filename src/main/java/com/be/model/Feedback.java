package com.be.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numberOfStars;
    private String comment;
    private Date date;
    @ManyToOne
    private House house;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Status status;
}
