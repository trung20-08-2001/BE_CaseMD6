package com.be.repository;

import com.be.model.Bill;
import com.be.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBillDetailRepository extends JpaRepository<BillDetail,Integer> {
    @Query("SELECT bd.bill FROM BillDetail bd WHERE bd.bill.id = :idBill")
    Bill findBillByBillDetailIdBill(int idBill);
}
