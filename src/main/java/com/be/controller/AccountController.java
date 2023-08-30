package com.be.controller;

import com.be.model.Account;
import com.be.model.House;

import com.be.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    IAccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @PostMapping("/createAccount")
    public void create(@RequestBody Account account) {
        accountService.save(account);
    }

    @PostMapping("/editAccount")
    public void edit(@RequestBody Account account) {
        accountService.edit(account);
    }

    @GetMapping("/deleteAccount/{id}")
    public void delete(@PathVariable int id) {
        accountService.delete(id);
    }

    @GetMapping("/searchAccount/{id}")
    public Account findById(@PathVariable int id) {
        return accountService.findById(id);
    }

    @GetMapping("/searchHouse")
    public ResponseEntity<List<House>> searchHouses(@RequestParam int idAccount, @RequestParam String name, @RequestParam String nameStatus) {
        List<House> houses = accountService.findByNameAndStatus(idAccount, "%" + name + "%", nameStatus);
        return ResponseEntity.ok(houses);
    }

    @PostMapping("/register")
    public Account register(@RequestBody Account account) {
       return accountService.getAccountByUsernameAndPhone(account.getUsername(), account.getPhone());
    }

}
