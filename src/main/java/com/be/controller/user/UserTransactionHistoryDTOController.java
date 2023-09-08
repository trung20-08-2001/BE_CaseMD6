package com.be.controller.user;

import com.be.model.Account;
import com.be.model.Bill;
import com.be.model.House;
import com.be.model.Status;
import com.be.model.dto.UserTransactionHistoryDTO;
import com.be.repository.IBillRepository;
import com.be.service.IAccountService;
import com.be.service.IHouseService;
import com.be.service.IUserTransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/bills_user")
public class UserTransactionHistoryDTOController {
    @Autowired
    IUserTransactionHistoryService iUserTransactionHistoryService;
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IHouseService iHouseService;
    @Autowired
    IBillRepository iBillRepository;

    @GetMapping("/{id}")
    public List<UserTransactionHistoryDTO> findAllBill_User(@PathVariable int id) {
        Account user = iAccountService.findById(id);
        return iUserTransactionHistoryService.findAllBill_User(user);
    }

    @PostMapping("/{id}/house")
    public House updateStatus_house(@PathVariable int id, @RequestParam int idStatus) {
        Status status = iUserTransactionHistoryService.findById_Status(idStatus);
        House house = iUserTransactionHistoryService.findHouseByBillId(id);
        house.setStatus(status);
        return iHouseService.save(house);
    }

    @PostMapping("/{id}/bill")
    public Bill updateStatus_bill(@PathVariable int id, @RequestParam int idStatus) {
        Status status = iUserTransactionHistoryService.findById_Status(idStatus);
        Bill bill = iUserTransactionHistoryService.findBillByBillDetailIdBill(id);
        bill.setStatus(status);
        return iBillRepository.save(bill);
    }
}
