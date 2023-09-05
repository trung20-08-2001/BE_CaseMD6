package com.be.controller.host;

import com.be.model.Account;
import com.be.model.Role;
import com.be.repository.IAccountRepository;
import com.be.repository.IRoleRepository;
import com.be.repository.IStatusRepository;
import com.be.service.IAccountService;
import com.be.service.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;

@RestController
@CrossOrigin("*")
public class HostController {
    @Autowired
    IAccountService iAccountService;
    @Autowired
    IRoleRepository iRoleRepository;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    IStatusRepository iStatusRepository;

    @PostMapping("/register")
    public ResponseEntity<Account> createHostAcc(@RequestBody Account account) {
        Role role = iRoleRepository.findByName("ROLE_HOST");
        account.setRole(role);
        iAccountService.saveAccount(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping("/listhost/{accountId}")
    public List<Account> getAllAccountByRole(@PathVariable int accountId) {
        Account account = iAccountService.findById(accountId);
        if (account.getRole().getId() == 1) {
            return iAccountService.findAllByRole(2);
        } else {
            return null;
        }
    }
}
