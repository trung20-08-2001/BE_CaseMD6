package com.be.repository;

import com.be.model.Account;
import com.be.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface IHouseRepository extends JpaRepository<House,Integer> {

    @Query(value = "select h from House h where h.name like '%'+:name+'%'")
    List<House> findHouseByName(@Param("name") String name);

    @Query(value = "select h from House h where h.account.id=:idAccount order by h.id desc")
    List<House> findHouseByAccount(@Param("idAccount") int idAccount);

    @Query("SELECT COUNT(h) FROM House h WHERE h.account = :account")
    int countHousesByAccount(Account account);

//    @Query(value = "select h from House h order by h.id desc limit 6")
//    List<House> findTopHouse();

}
