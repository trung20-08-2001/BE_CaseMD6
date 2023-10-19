package com.be.controller.admin;

import com.be.model.dto.AccountUserDTO;
import com.be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.be.model.Account;
import com.be.model.Role;
import com.be.model.Status;
import com.be.repository.IRoleRepository;
import com.be.repository.IStatusRepository;
import com.be.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
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
    @GetMapping("/findAccountUsers")
    public List<AccountUserDTO> findAccountUsers(){
        return iAccountService.findAccountUsers();
    }

    @GetMapping("/updateStatus/{status_id}/{idAccount}")
    public  void updateStatus(@PathVariable int status_id, @PathVariable int idAccount){
        iAccountService.updateStatus(status_id, idAccount);
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
