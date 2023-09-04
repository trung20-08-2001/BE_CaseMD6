package com.be.controller.admin;

import com.be.model.Account;
import com.be.model.Role;
import com.be.model.Status;
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

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/")
public class AdminController {
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

    @PostMapping("registration/req/{accountId}")
    public ResponseEntity<Account> registerAsHost(@PathVariable int accountId,
                                                  @RequestBody Account account) {
        Account account1 = iAccountService.findById(accountId);
        if (account1 != null) {
            account.setId(accountId);
            Status status = iStatusRepository.findById(2);
            account.setStatus(status);
            account.setRole(account1.getRole());
            account.setAvatar(account1.getAvatar());
            account.setPassword(account1.getPassword());
            account.setUsername(account1.getUsername());
            iAccountService.saveAccount(account);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PostMapping("registration/approve/{accountId}")
    public ResponseEntity<Account> approveRegistration(@PathVariable int accountId,
                                                       @RequestBody Account account) {
        Account account1 = iAccountService.findById(accountId);
        if (account1 != null) {
            account.setId(accountId);
            Role role = iRoleRepository.findById(2);
            account.setRole(role);
            Status status = iStatusRepository.findById(1);
            account.setStatus(status);
            account.setAvatar(account1.getAvatar());
            account.setPassword(account1.getPassword());
            account.setUsername(account1.getUsername());
            iAccountService.saveAccount(account);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("registration/reject/{accountId}")
    public ResponseEntity<Account> rejectRegistration(@PathVariable int accountId,
                                                      @RequestBody Account account) {
        Account account1 = iAccountService.findById(accountId);
        if (account1 != null) {
            account.setId(accountId);
            Role role = iRoleRepository.findById(3);
            account.setRole(role);
            Status status = iStatusRepository.findById(1);
            account.setStatus(status);
            account.setAvatar(account1.getAvatar());
            account.setPassword(account1.getPassword());
            account.setUsername(account1.getUsername());
            iAccountService.saveAccount(account);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("registration/req/{accountId}")
    public List<Account> findAllByStatus(@PathVariable int accountId) {
        Account account = iAccountService.findById(accountId);
        if (account.getRole().getId() == 1) {
            return iAccountService.findAllByStatus(2);
        } else {
            return null;
        }

    }

}
