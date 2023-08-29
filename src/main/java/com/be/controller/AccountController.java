package com.be.controller;

import com.be.model.Account;
import com.be.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @PostMapping("/createAccount")
    public void create(@RequestBody Account account) {
        accountService.save(account);
    }

    @PostMapping("/editAccount")
    public void edit(@RequestBody Account account){
        accountService.edit(account);
    }

    @GetMapping("/deleteAccount/{id}")
    public void delete(@PathVariable int id) {
        accountService.delete(id);
    }

    @GetMapping("/searchAccount/{id}")
    public Account findById(@PathVariable int id){
        return accountService.findById(id);
    }
}
