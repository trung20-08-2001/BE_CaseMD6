package com.be.controller.admin;


import com.be.model.dto.AccountUserDTO;
import com.be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAccountService iAccountService;

    @GetMapping("/findAccountUsers")
    public List<AccountUserDTO> findAccountUsers(){
        return iAccountService.findAccountUsers();
    }
}
