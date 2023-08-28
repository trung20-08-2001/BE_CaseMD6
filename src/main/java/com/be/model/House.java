package com.be.model;
import lombok.Data;
import javax.persistence.*;

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
    private String description;
    private double price;
    private String imageMain;
    @ManyToOne
    private Status status;
}