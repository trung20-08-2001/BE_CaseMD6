package com.be.service;

import com.be.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends UserDetailsService {
    Account saveAccount(Account account);
    Account getAccountByUsernameAndPassword(String username, String password);
}
