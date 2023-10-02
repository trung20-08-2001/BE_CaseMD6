package com.be.repository;

import com.be.model.Account;
import com.be.model.Bill;
import com.be.model.House;
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

    @Query("SELECT SUM(b.totalPrice) FROM Bill b WHERE b.vendor = :vendor")
    Double getTotalPriceByAccount(@Param("vendor") Account vendor);

    @Query(nativeQuery = true,value = "SELECT DISTINCT  YEAR(date_checkout) AS 'year' FROM bill  where vendor_id=:idHost and status_id=7")
    List<Integer> findAllYearActiveOfHost(@Param("idHost") int idHost);

    @Query(value ="SELECT b from Bill  b where b.dateCheckin>=:newDateCheckin" )
    Optional<Bill> checkDateCheckin(@Param("newDateCheckin")Date checkin);

    @Query(value = "select b  from Bill b where (b.status.id=6 or b.status.id=5) and b.house.id=:idHouse")
    List<Bill> findBillByStatusAndHouse(@Param("idHouse") int idHouse);
    @Query(value = "select sum(b.totalPrice) from Bill b where month(b.dateCheckout)=:month and year(b.dateCheckout)=:year and b.vendor.id=:idHost")
    Optional<Double> calculateTotalRevenueByTime(@Param("month") int month, @Param("year") int year,@Param("idHost") int idHost);
    @Query(value = "SELECT b.house from Bill b where b.id=:billId")
    House findHouseByBillId(@Param("billId") int billId);

    @Query("SELECT b FROM Bill b JOIN b.status bs WHERE b.vendor = ?1 ORDER BY bs.id ASC, b.id DESC")
    List<Bill> findAllByVendorOrderByDescendingIdAndStatusId(Account vendor);

    @Query("SELECT b FROM Bill b JOIN b.status bs WHERE b.user = ?1 ORDER BY bs.name DESC, b.id DESC")
    List<Bill> findAllByUserOrderByStatusNameDescAndIdStatusAndId(Account user);

    @Query("select b from Bill b where b.house.id=:idHouse and b.dateCheckin>=CURRENT_DATE and b.status.id != 8")
    List<Bill> findDateOfBill(int idHouse);
}
