package com.be.repository;

import com.be.model.Account;
import com.be.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBillRepository extends JpaRepository<Bill,Integer> {
    @Query("SELECT SUM(b.totalPrice) FROM Bill b WHERE b.account = :account")
    Double getTotalPriceByAccount(@Param("account") Account account);
}
