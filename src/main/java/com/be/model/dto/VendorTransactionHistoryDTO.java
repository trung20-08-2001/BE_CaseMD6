package com.be.model.dto;

import com.be.model.Bill;
import com.be.model.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorTransactionHistoryDTO {
    private int id;
    private House house;
    private Bill bill;
}
