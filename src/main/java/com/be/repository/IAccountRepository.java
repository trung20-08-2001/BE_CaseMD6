package com.be.repository;

import com.be.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  IAccountRepository extends JpaRepository<Account,Integer> {
}
