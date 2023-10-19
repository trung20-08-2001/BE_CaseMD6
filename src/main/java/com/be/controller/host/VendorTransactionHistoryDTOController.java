package com.be.controller.host;

import com.be.model.Account;
import com.be.model.Bill;
import com.be.model.House;
import com.be.model.Status;
import com.be.model.dto.VendorTransactionHistoryDTO;
import com.be.repository.IBillRepository;
import com.be.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/bills_vendor")
public class VendorTransactionHistoryDTOController {
    @Autowired
    IVendorTransactionHistoryDTOService iVendorTransactionHistoryDTOService;
    @Autowired
    IUserTransactionHistoryService iUserTransactionHistoryService;
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IBillRepository iBillRepository;
    @Autowired
    IHouseDTOService iHouseDTOService;

    @GetMapping("/{id}")
    public List<VendorTransactionHistoryDTO> findAllBill_Vendor(@PathVariable int id) {
        Account vendor = iAccountService.findById(id);
        return iVendorTransactionHistoryDTOService.findAllBill_Vendor(vendor);
    }

    @PostMapping("/{id}/house")
    public House updateStatus_house(@PathVariable int id, @RequestBody House house) {
        House house1 = iUserTransactionHistoryService.findHouseByBillId(id);
        Status status = house.getStatus();
        house1.setStatus(status);
        return iHouseDTOService.saveHouse(house1);
    }

    @PostMapping("/{id}/bill")
    public Bill updateStatus_bill(@PathVariable int id, @RequestBody Bill bill) {
        Bill bill1 = iUserTransactionHistoryService.findById(id);
        Status status = bill.getStatus();
        bill1.setStatus(status);
        bill1.setTotalPrice(bill.getTotalPrice());
        bill1.setDateCheckout(bill.getDateCheckout());
        return iBillRepository.save(bill1);
    }
}
