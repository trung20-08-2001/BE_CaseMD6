package com.be.service.impl;

import com.be.model.*;
import com.be.model.dto.UserTransactionHistoryDTO;
import com.be.repository.IBillDetailRepository;
import com.be.repository.IStatusRepository;
import com.be.service.IAccountService;
import com.be.service.IUserTransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserTransactionHistoryImpl implements IUserTransactionHistoryService {
    @Autowired
    IBillDetailRepository iBillDetailRepository;
    @Autowired
    IStatusRepository iStatusRepository;
    @Autowired
    IAccountService iAccountService;

    @Override
    public Status findById_Status(int id) {
        return iStatusRepository.findById(id);
    }

    public List<BillDetail> findAllByBill_User(Account user) {
        return iBillDetailRepository.findAllByBill_User(user);
    }

    @Override
    public List<UserTransactionHistoryDTO> findAllBill_User(Account user) {
        List<UserTransactionHistoryDTO> userTransactionHistoryDTOList = new ArrayList<>();
        UserTransactionHistoryDTO userTransactionHistoryDTO;
        Status status = findById_Status(8);
        int countId = 0;
        for (BillDetail billDetail : findAllByBill_User(user)) {
            House house = billDetail.getHouse();
            Bill bill = billDetail.getBill();
            userTransactionHistoryDTO = new UserTransactionHistoryDTO(countId++, house, bill, status);
            userTransactionHistoryDTOList.add(userTransactionHistoryDTO);
        }
        return userTransactionHistoryDTOList;
    }

    @Override
    public House findHouseByBillId(int billId) {
        return iBillDetailRepository.findHouseByBillId(billId);
    }

    @Override
    public Bill findBillByBillDetailIdBill(int idBill) {
        return iBillDetailRepository.findBillByBillDetailIdBill(idBill);
    }
}
