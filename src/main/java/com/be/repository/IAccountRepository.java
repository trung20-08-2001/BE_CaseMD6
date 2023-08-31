package com.be.repository;

import com.be.model.Account;
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

    @Query("SELECT a FROM Account a JOIN a.role r WHERE r.name = 'ROLE_HOST'")
    List<Account> findAccountsByRoleName_Vendor();

}
