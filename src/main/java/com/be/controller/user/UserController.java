package com.be.controller.user;

import com.be.model.*;
import com.be.repository.IStatusRepository;
import com.be.service.IAccountService;
import com.be.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    IAccountService iAccountService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    IStatusRepository iStatusRepository;
    @Autowired
    JwtService jwtService;

    @PostMapping("/registration/req/{accountId}")
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

    @PostMapping("/api/login")
    public ResponseEntity<?> getLogin(@RequestBody Account account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        account = iAccountService.getAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
        if (account != null) {
            if (account.getStatus().getId() == 3) {
                ErrorResponse errorResponse = new ErrorResponse("Tài khoản đã bị khóa");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
            } else {
                String token = jwtService.createToken(authentication);
                AccountToken accountToken = new AccountToken(account.getId(), account.getUsername(), account.getRole(), account.getAddress(), account.getPhone(), account.getAvatar(), account.getStatus(), account.getFullName(), token);
                return ResponseEntity.ok(accountToken);
            }
        } else {
            return null;
        }
    }
    private int x = 1;
    public void increaseX() {
        x++;
    }

    @PostMapping("/loginBySocialNetwork")
    public ResponseEntity<?> loginByGoogle(@RequestBody Account account) {
        Account account1 = iAccountService.findAccountByPassword(account.getPassword());
        if (account1 != null) {
            if (account1.getStatus().getId() == 3) {
                ErrorResponse errorResponse = new ErrorResponse("Tài khoản đã bị khóa");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
            } else {
                return authenticateAccount(account1);
            }
        } else {
            Account newAccount = new Account();
            newAccount.setUsername(account.getUsername()+x);
            newAccount.setPassword(account.getPassword());
            newAccount.setAvatar(account.getAvatar());
            newAccount.setEmail(account.getEmail());
            newAccount.setFullName(account.getFullName());
            Role role = new Role();
            role.setId(3);
            Status status = new Status();
            status.setId(1);
            newAccount.setRole(role);
            newAccount.setStatus(status);
            iAccountService.saveAccount(newAccount);
            increaseX();
            return authenticateAccount(newAccount);
        }
    }

    private ResponseEntity<?> authenticateAccount(Account account) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtService.createToken(authentication);
            AccountToken accountToken = new AccountToken(account.getId(), account.getUsername(), account.getRole(), account.getAddress(), account.getPhone(), account.getAvatar(), account.getStatus(), account.getFullName(), token);
            return ResponseEntity.ok(accountToken);
        } catch (AuthenticationException e) {
            ErrorResponse errorResponse = new ErrorResponse("Lỗi xác thực");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}
