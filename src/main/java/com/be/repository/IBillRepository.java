package com.be.repository;

import com.be.model.Account;
import com.be.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBillRepository extends JpaRepository<Bill,Integer> {
    @Query(value = "select b from Bill b where b.user.id=:idAccount")
    List<Bill> findBillByAccountId(@Param("idAccount") Integer idAccount);

    @Query(value = "select sum(b.totalPrice) from Bill b where b.user.id=:idAccount")
    Optional<Double> getTotalPriceByAccountId(@Param("idAccount") int idAccount);

    @Query("SELECT SUM(b.totalPrice) FROM Bill b WHERE b.vendor = :account")
    Double getTotalPriceByAccount(@Param("account") Account account);

   @Query(nativeQuery = true,value = "SELECT DISTINCT  YEAR(date_checkout) AS 'year' FROM Bill  where vendor_id=:idHost")
    List<Integer> findAllYearActiveOfHost(@Param("idHost") int idHost);

   @Query(value = "select sum(b.totalPrice) from Bill b where month(b.dateCheckout)=:month and year(b.dateCheckout)=:year and b.vendor.id=:idHost")
    Optional<Double> calculateTotalRevenueByTime(@Param("month") int month, @Param("year") int year,@Param("idHost") int idHost);

}
