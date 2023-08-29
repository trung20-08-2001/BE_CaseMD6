package com.be.model;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private int numberOfBedrooms;
    private int numberOfLivingRooms;
    private int numberOfHire;
    @Column(columnDefinition = "TEXT")
    private String description;
    private double price;
    @ManyToOne
    private Status status;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Account account;

}