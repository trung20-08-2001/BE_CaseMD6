package com.be.controller;

import com.be.model.Bill;
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

    @GetMapping("/{dateCheckin}/{dateCheckout}/{numberOfDate}")
    public boolean order(@PathVariable String dateCheckin,@PathVariable String dateCheckout,@PathVariable int numberOfDate){
        Date sqlDateCheckin = Date.valueOf(dateCheckin);
        Date sqlDateCheckout = Date.valueOf(dateCheckout);
        return iOrderService.checkDateOrder(sqlDateCheckin, sqlDateCheckout,numberOfDate);
    }

    @PostMapping("/saveBill")
    public void saveBill(@RequestBody Bill bill){
        iOrderService.saveBill(bill);
    }

    @GetMapping("/{idHouse}")
    public List<LocalDate> order(@PathVariable int idHouse){
        return iOrderService.checkDateOrder(idHouse);
    }

    @GetMapping("/listDate/{idHouse}")
    public List<Bill> getListDate(@PathVariable int idHouse){
        return iOrderService.findDateOfBill(idHouse);
    }
}
