package com.be.repository;

import com.be.model.Account;
import com.be.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Query("select a from Account a where a.username=:u")
    Account getAccountByUsername(@Param("u") String username);

    @Query("select a from Account a where a.username= :username and a.password= :password")
    Account getAccountByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    @Query(value = "select h from House h where h.account.id=:idAccount and h.name like :name and h.status.name=:nameStatus")
    List<House> findByNameAndStatus(@Param("idAccount") int idAccount, @Param("name") String name, @Param("nameStatus") String nameStatus);


    @Query("select a from Account a where a.username=:u or a.phone=:p")
    Optional<Account> getAccountByUsernameAndPhone(@Param("u") String username, @Param("p")String phone );

    @Query(value = "select a from Account a where a.role.id=3 order by a.id desc")
    List<Account> findAccountUser();
}
