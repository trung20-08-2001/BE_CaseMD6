package com.be.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class HouseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    @ManyToOne
    private House house;
}