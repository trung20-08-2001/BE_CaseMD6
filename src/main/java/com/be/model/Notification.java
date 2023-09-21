package com.be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    private Account account;
    private LocalDateTime time=LocalDateTime.now();
    private boolean seen=false;
    private  String url;
}
