package com.be.repository;

import com.be.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface  IAccountRepository extends JpaRepository<Account,Integer> {
    @Query("select a from Account a where a.username=:u")
    Account getAccountByUsername(@Param("u") String username);
}
