package com.be.service.impl;

import com.be.model.Bill;
import com.be.repository.IBillRepository;
import com.be.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IBillRepository iBillRepository;
    @Override
    public boolean checkDateOrder(Date dateCheckin, Date dateCheckout,int idHouse) {
        List<Bill> billList = iBillRepository.findBillByStatusAndHouse(idHouse);
        System.out.println(billList.toString());
        for (Bill bill : billList) {
            if (bill.getDateCheckin().compareTo(dateCheckin) >= 0 && bill.getDateCheckout().compareTo(dateCheckout) <= 0) {
               return false;
            }
        }
        return true;
    }

    @Override
    public void saveBill(Bill bill) {
        iBillRepository.save(bill);
    }

    @Override
    public List<LocalDate> checkDateOrder(int idHouse) {
        List<Bill> bills = iBillRepository.findDateOfBill(idHouse);
        List<LocalDate> dateRange = new ArrayList<>();
        for (Bill bill : bills) {
            getDateRange(bill.getDateCheckin().toLocalDate(), bill.getDateCheckout().toLocalDate(),dateRange);
        }
        return dateRange;
    }

    @Override
    public List<Bill> findDateOfBill(int idHouse) {
        return iBillRepository.findDateOfBill(idHouse);
    }

    @Override
    public List<LocalDate> getDateRange(LocalDate startDate, LocalDate endDate, List<LocalDate> dateRange) {
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            dateRange.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        return dateRange;
    }
}
