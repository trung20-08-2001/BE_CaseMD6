package com.be.service;

import com.be.model.Account;

import com.be.model.Bill;
import com.be.model.House;
import com.be.model.Status;
import com.be.model.dto.VendorTransactionHistoryDTO;

import java.util.List;

public interface IVendorTransactionHistoryDTOService{
    List<VendorTransactionHistoryDTO> findAllBill_Vendor(Account vendor);
    List<VendorTransactionHistoryDTO> findBill_rentingHouse_Vendor(Account vendor);
}
