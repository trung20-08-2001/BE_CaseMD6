package com.be.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date dateCheckin;
    private Date dateCheckout;
    @Column(columnDefinition = "decimal(38,0) default 0")
    private BigDecimal totalPrice;
    @ManyToOne
    private Account user;
    @ManyToOne
    private Account vendor;
    @ManyToOne
    private Status status;
    @ManyToOne
    private House house;
}