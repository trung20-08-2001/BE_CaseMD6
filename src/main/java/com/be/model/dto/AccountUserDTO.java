package com.be.model.dto;

import com.be.model.Bill;
import com.be.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountUserDTO {
    private int id;
    private String avatar;
    private String username;
    private String fullName;
    private String phone;
    private Status status;
    private double totalAllBill;
    private List<Bill> bills;
}