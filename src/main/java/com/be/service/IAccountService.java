package com.be.service;

import com.be.model.Account;
import com.be.model.House;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IAccountService extends UserDetailsService {
    List<Account> getAll();
    void save(Account e);
    void edit(Account e);
    void  delete(int id);
    Account findById(int id);
    List<House> findByNameAndStatus(int idAccount,String name,String nameStatus);
    Account getAccountByUsernameAndPhone(String username,String phone);
}
