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
    public List<Account> getAll() {
        return iAccountService.findAll();
    }

    @PostMapping("/createAccount")
    public void create(@RequestBody Account account) {
        iAccountService.saveAccount(account);
    }

    @PostMapping("/editAccount")
    public void edit(@RequestBody Account account){
        iAccountService.edit(account);
    }

    @GetMapping("/deleteAccount/{id}")
    public void delete(@PathVariable int id) {
        iAccountService.delete(id);
    }

    @GetMapping("/searchAccount/{id}")
    public Account findById(@PathVariable int id) {
        return iAccountService.findById(id);

    }

    @PostMapping("/edit/{id}")
    public void editAccount(Account account, @PathVariable int id) {
        account.setId(id);
        iAccountService.edit(account);
    }
}
