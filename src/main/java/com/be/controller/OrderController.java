package com.be.controller;

import com.be.model.Bill;
import com.be.repository.IBillRepository;
import com.be.service.IBillService;
import com.be.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderService  iOrderService;

    @GetMapping("/{idHouse}")
    public List<LocalDate> order(@PathVariable int idHouse){
    return iOrderService.checkDateOrder(idHouse);
    }

    @PostMapping("/saveBill")
    public void saveBill(@RequestBody Bill bill){
        iOrderService.saveBill(bill);
    }

    @GetMapping("/listDate/{idHouse}")
    public List<Bill> getListDate(@PathVariable int idHouse){
        return iOrderService.findDateOfBill(idHouse);
    }

}
