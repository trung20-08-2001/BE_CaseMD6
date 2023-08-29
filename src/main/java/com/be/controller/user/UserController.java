package com.be.controller.user;

import com.be.model.Account;
import com.be.model.AccountToken;
import com.be.service.IAccountService;
import com.be.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    public AccountToken getLogin(@RequestBody Account account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        account = iAccountService.getAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
        String token = jwtService.createToken(authentication);
        AccountToken accountToken = new AccountToken(account.getId(),account.getUsername(),account.getRole(),token);
        return accountToken;
    }
}
