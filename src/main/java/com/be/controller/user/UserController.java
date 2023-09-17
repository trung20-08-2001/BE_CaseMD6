package com.be.controller.user;

import com.be.model.*;
import com.be.repository.IAccountRepository;
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
    JwtService jwtService;

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

    @PostMapping("/loginByGoogle")
    public ResponseEntity<?> loginByGoogle(@RequestBody Account account) {
        Account account1 = iAccountService.findByName(account.getUsername());
        if (account1 != null) {
            if (account1.getStatus().getId() == 3) {
                ErrorResponse errorResponse = new ErrorResponse("Tài khoản đã bị khóa");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
            } else {
                return authenticateAccount(account1);
            }
        } else {
            Account account2 = new Account();
            account2.setUsername(account.getUsername());
            account2.setPassword("LoginByGoogle");
            account2.setAvatar(account.getAvatar());
            Role role = new Role();
            role.setId(3);
            Status status = new Status();
            status.setId(1);
            account2.setRole(role);
            account2.setStatus(status);
            iAccountService.saveAccount(account2);
            return authenticateAccount(account2);
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
