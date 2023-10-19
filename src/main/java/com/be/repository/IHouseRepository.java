package com.be.repository;

import com.be.model.Account;
import com.be.model.House;
import com.be.model.dto.HouseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;

public interface IHouseRepository extends JpaRepository<House, Integer> {

    @Query(value = "select h from House h where h.account.id=:idAccount order by h.id desc")
    List<House> findHouseByAccount(@Param("idAccount") int idAccount);

    @Query("SELECT COUNT(h) FROM House h WHERE h.account = :account")
    int countHousesByAccount(Account account);

    @Query("SELECT h FROM House h WHERE h.name LIKE CONCAT('%', :nameHouse, '%') AND h.status.id = :statusId and h.account.id=:accountId")
    List<House> findAllByNameAndStatus(@Param("nameHouse") String nameHouse, @Param("statusId") int statusId, @Param("accountId") int accountId);

    @Query("SELECT h FROM House h WHERE h.name LIKE CONCAT('%', :nameHouse, '%') and h.account.id=:accountId")
    List<House> findAllByName(@Param("nameHouse") String nameHouse, @Param("accountId") int accountId);

    @Query("select h from House h where h.status.id = :statusId and h.account.id=:accountId")
    List<House> findAllByStatus(@Param("statusId") int statusId, @Param("accountId") int accountId);
    @Query("select h from House h where h.id= :houseId")
    House findById(@Param("houseId")int houseId);

    @Query(value = "select h from House h  where h.status.id!=3")
    Page<House> findAllHouse(Pageable pageable);

    @Query(value = "select h from House h  where h.status.id!=3")
    List<House> getAllHouse();
}
