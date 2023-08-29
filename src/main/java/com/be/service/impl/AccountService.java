package com.be.service.impl;

import com.be.model.Account;
import com.be.repository.IAccountRepository;
import com.be.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements ICrudService<Account> {
    @Autowired
    IAccountRepository iAccountRepository;

    @Override
    public List<Account> getAll() {
        return (List<Account>) iAccountRepository.findAll();
    }

    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public void edit(Account account) {
     iAccountRepository.save(account);
    }

    @Override
    public void delete(int id) {
     iAccountRepository.deleteById(id);
    }

    @Override
    public Account findById(int id) {
        return iAccountRepository.findById(id).orElse(null);
    }
}
