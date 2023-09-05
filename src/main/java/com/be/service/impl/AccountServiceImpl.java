package com.be.service.impl;

import com.be.model.Account;
import com.be.model.House;
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
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository iAccountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepository.getAccountByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUsername(), account.getPassword(), roles);
    }

    @Override
    public Account saveAccount(Account account) {
        return iAccountRepository.save(account);
    }

    @Override
    public Account getAccountByUsernameAndPassword(String username, String password) {
        return iAccountRepository.getAccountByUsernameAndPassword(username, password);
    }

    public List<Account> findAll() {
        return iAccountRepository.findAll();
    }
    public Account getAccountByUsernameAndPhone(String username, String phone) {
        Optional<Account> accountOptional= iAccountRepository.getAccountByUsernameAndPhone(username,phone);
        return accountOptional.orElse(null);
    }

    @Override
    public List<Account> findAllByStatus(int status_id) {
        return iAccountRepository.findAllByStatus(status_id);
    }

    @Override
    public List<Account> findAllByRole(int role_id) {
        return iAccountRepository.findAccountByRole(role_id);
    }


    @Override
    public void edit(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public Account findById(int id) {
        return iAccountRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        iAccountRepository.deleteById(id);
    }

    @Override
    public List<House> findByNameAndStatus(int idAccount, String name, String nameStatus) {
        return iAccountRepository.findByNameAndStatus(idAccount, name, nameStatus);
    }
}