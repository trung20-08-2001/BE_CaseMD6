package com.be.controller.user;

import com.be.model.Account;
import com.be.model.Bill;
import com.be.model.House;
import com.be.model.dto.UserTransactionHistoryDTO;
import com.be.repository.IBillRepository;
import com.be.service.IAccountService;
import com.be.service.IHouseDTOService;
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
    IBillRepository iBillRepository;
    @Autowired
    IHouseDTOService iHouseDTOService;

    @GetMapping("/{id}")
    public List<UserTransactionHistoryDTO> findAllBill_User(@PathVariable int id) {
        Account user = iAccountService.findById(id);
        return iUserTransactionHistoryService.findAllBill_User(user);
    }

    @PostMapping("/house")
    public House updateStatus_house( @RequestBody House house) {
        return iHouseDTOService.saveHouse(house);
    }

    @PostMapping("/bill")
    public Bill updateStatus_bill( @RequestBody Bill bill) {
        return iBillRepository.save(bill);
    }
}
