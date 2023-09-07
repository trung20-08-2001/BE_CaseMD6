package com.be.model.dto;

import com.be.model.Bill;
import com.be.model.House;
import com.be.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTransactionHistoryDTO {
    private int id;
    private House house;
    private Bill bill;
    private Status status;
}
