package com.be.service;

import com.be.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    List<Account> findAll();
    void edit(Account account);
    Account findByID(int id);
}
