package com.be.service;

import com.be.model.Bill;

import java.sql.Date;

public interface IOrderService {
     boolean checkDateOrder(Date dateCheckin,Date dateCheckout,int idHouse);

     void saveBill(Bill bill);


}
