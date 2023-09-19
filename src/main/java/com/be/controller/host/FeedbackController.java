package com.be.controller.host;

import com.be.model.Account;
import com.be.model.Feedback;
import com.be.model.Role;
import com.be.model.dto.Revenue;
import com.be.repository.IRoleRepository;
import com.be.repository.IStatusRepository;
import com.be.service.IAccountService;
import com.be.service.IBillService;
import com.be.service.IFeedBackService;
import com.be.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/feedback")
public class FeedbackController {
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
    @Autowired
    IBillService iBillService;
    @Autowired
    IFeedBackService iFeedBackService;
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

    @GetMapping("/findRevenueOfHost/{idHost}")
    public List<Revenue> findRevenueOfHost(@PathVariable int idHost){
        return iBillService.findRevenueOfHost(idHost);
    }

    @GetMapping("getAllFeedback/{houseId}")
    public List<Feedback> getAllByHouseId(@PathVariable int houseId) {
        return iFeedBackService.getAllByHouse_Id(houseId);
    }
    @PostMapping("updateFeedback/{feedbackId}/{houseId}")
    public List<Feedback> updateFeedback(@PathVariable int feedbackId,@PathVariable int houseId){
        iFeedBackService.updateFeedback(feedbackId);
        return iFeedBackService.getAllByHouse_Id(houseId);
    }
    @GetMapping("getAllByStar/{houseId}/{star}")
    public List<Feedback> getAllByStar(@PathVariable int houseId,
                                       @PathVariable int star) {
        return iFeedBackService.getAllByStar(houseId,star);
    }
    @GetMapping("getAllFeedbackByComment/{houseId}")
    public List<Feedback> getAllFeedbackByComment(@PathVariable int houseId){
        return iFeedBackService.getAllFeedbackByComment(houseId);
    }
}
