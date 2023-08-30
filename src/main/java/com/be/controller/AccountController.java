package com.be.controller;

import com.be.model.Account;
import com.be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    IAccountService iAccountService;

    @GetMapping
    public List<Account> findAllAccount() {
        return iAccountService.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable int id) {
        return iAccountService.findByID(id);
    }

    @PostMapping("/edit/{id}")
    public void editAccount(Account account, @PathVariable int id) {
        account.setId(id);
        iAccountService.edit(account);
    }
}
