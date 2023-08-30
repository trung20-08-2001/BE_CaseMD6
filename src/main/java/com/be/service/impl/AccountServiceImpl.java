package com.be.service.impl;

import com.be.model.Account;
import com.be.repository.IAccountRepository;
import com.be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.getAccountByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUsername(), account.getPassword(), roles);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountByUsernameAndPassword(String username, String password) {
        return accountRepository.getAccountByUsernameAndPassword(username, password);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void edit(Account account) {
        accountRepository.save(account);
    }



    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        accountRepository.deleteById(id);
    }
}
