package com.be.model;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
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
    @Column(columnDefinition = "integer default 0")
    private int searchVolume;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "decimal(38,0) default 0")
    private BigDecimal price;
    @ManyToOne
    private Status status;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Account account;
}