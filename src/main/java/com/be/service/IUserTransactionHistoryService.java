package com.be.service;

import com.be.model.Account;
import com.be.model.House;
import com.be.model.Bill;
import com.be.model.Status;
import com.be.model.dto.UserTransactionHistoryDTO;

import java.util.List;

public interface IUserTransactionHistoryService {
    List<UserTransactionHistoryDTO> findAllBill_User(Account user);
    House findHouseByBillId(int billId);
    Bill findById(int idBill);
    Status findById_Status(int id);
}
