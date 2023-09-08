package com.be.service.impl;

import com.be.model.*;
import com.be.model.dto.UserTransactionHistoryDTO;
import com.be.repository.IBillDetailRepository;
import com.be.repository.IBillRepository;
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
    @Autowired
    IBillRepository iBillRepository;

    @Override
    public Status findById_Status(int id) {
        return iStatusRepository.findById(id);
    }

    public List<Bill> findAllByBill_User(Account user) {
        return iBillRepository.findBillByAccountId(user.getId());
    }

    @Override
    public List<UserTransactionHistoryDTO> findAllBill_User(Account user) {
        List<UserTransactionHistoryDTO> userTransactionHistoryDTOList = new ArrayList<>();
        UserTransactionHistoryDTO userTransactionHistoryDTO;
        Status status = findById_Status(8);
        int countId = 0;
        for (Bill bill : iBillRepository.findAllByUserOrderByStatusNameDescAndIdStatusAndId(user)) {
            House house = bill.getHouse();
            userTransactionHistoryDTO = new UserTransactionHistoryDTO(countId++, house, bill, status);
            userTransactionHistoryDTOList.add(userTransactionHistoryDTO);
        }
        return userTransactionHistoryDTOList;
    }

    @Override
    public House findHouseByBillId(int billId) {
        return iBillRepository.findHouseByBillId(billId);
    }

    @Override
    public Bill findBillByBillDetailIdBill(int idBill) {
        return iBillDetailRepository.findBillByBillDetailIdBill(idBill);
    }
}
