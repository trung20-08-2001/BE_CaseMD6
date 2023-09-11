package com.be.repository;

import com.be.model.Account;
import com.be.model.Bill;
import com.be.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBillDetailRepository extends JpaRepository<BillDetail,Integer> {
    List<BillDetail> findAllByBill_UserOrderByBill_Status_NameDescBill_IdDesc(Account user);

    List<BillDetail> findAllByBill_VendorOrderByBill_Status_IdAscBill_IdDesc(Account vendor);

    @Query("SELECT bd.bill FROM BillDetail bd WHERE bd.bill.id = :idBill")
    Bill findBillByBillDetailIdBill(int idBill);
}
