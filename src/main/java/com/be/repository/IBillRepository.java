package com.be.repository;

import com.be.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBillRepository extends JpaRepository<Bill,Integer> {
    @Query(value = "select b from Bill b where b.account.id=:idAccount")
    List<Bill> findBillByAccountId(@Param("idAccount") Integer idAccount);

    @Query(value = "select sum(b.totalPrice) from Bill b where b.account.id=:idAccount")
    Optional<Double> getTotalPriceByAccountId(@Param("idAccount") int idAccount);
}
