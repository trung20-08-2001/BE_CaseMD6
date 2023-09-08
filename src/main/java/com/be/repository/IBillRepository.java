package com.be.repository;

import com.be.model.Account;
import com.be.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IBillRepository extends JpaRepository<Bill,Integer> {
    @Query(value = "select b from Bill b where b.user.id=:idAccount")
    List<Bill> findBillByAccountId(@Param("idAccount") Integer idAccount);

    @Query(value = "select sum(b.totalPrice) from Bill b where b.user.id=:idAccount")
    Optional<Double> getTotalPriceByAccountId(@Param("idAccount") int idAccount);

    @Query("SELECT SUM(b.totalPrice) FROM Bill b WHERE b.vendor = :account")
    Double getTotalPriceByAccount(@Param("account") Account account);

    @Query(value ="SELECT b from Bill  b where b.dateCheckin>=:newDateCheckin" )
    Optional<Bill> checkDateCheckin(@Param("newDateCheckin")Date checkin);

    @Query(value = "select b  from Bill b where (b.status.id=6 or b.status.id=5) and b.house.id=:idHouse")
    List<Bill> findBillByStatusAndHouse(@Param("idHouse") int idHouse);
}
