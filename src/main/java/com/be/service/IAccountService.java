package com.be.service;

import com.be.model.Account;
import com.be.model.House;
import com.be.model.dto.AccountUserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {

    Account saveAccount(Account account);
    Account getAccountByUsernameAndPassword(String username, String password);
    List<Account> findAll();
    void edit(Account account);
    Account findById(int id);
    void delete(int id);
    List<House> findByNameAndStatus(int idAccount, String name, String nameStatus);
    Account getAccountByUsernameAndPhone(String username,String phone);
    List<AccountUserDTO> findAccountUsers();
    List<Account> findAllByStatus(int status_id);
    void  updateStatus(int status_id,int idAccount);
    List<Account> findAllByRole(int role_id);
    Account findAccountAdmin();
    List<Account> findAccountHostByUsername(String username);
    Account findAccountByPassword(String password);
    List<Account> findAccountsYouMessaged(int idAccount);
    void updateAccountToHost(int roleId,int statusId,int accountId);
}