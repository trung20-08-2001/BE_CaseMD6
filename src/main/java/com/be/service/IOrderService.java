package com.be.service;

import com.be.model.Bill;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IOrderService {
     List<LocalDate> checkDateOrder(int idHouse);

     void saveBill(Bill bill);

     List<Bill> findDateOfBill(int idHouse);

       List<LocalDate> getDateRange(LocalDate startDate, LocalDate endDate,List<LocalDate> dateRange) ;


}
