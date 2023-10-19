package com.be.controller.host;

import com.be.model.Account;
import com.be.model.House;
import com.be.model.Bill;
import com.be.model.Role;
import com.be.model.dto.HouseDTO;
import com.be.model.dto.Revenue;
import com.be.repository.IAccountRepository;
import com.be.repository.IBillRepository;
import com.be.repository.IRoleRepository;
import com.be.repository.IStatusRepository;
import com.be.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.Authenticator;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("host")
public class HostController {
    @Autowired
    IBillService iBillService;
    @Autowired
    private IHouseDTOService iHouseDTOService;
    @PostMapping("/saveHouse")
    public House save(@RequestBody House house) {
        return iHouseDTOService.saveHouse(house);
    }
    @GetMapping("/findRevenueOfHost/{idHost}")
    public List<Revenue> findRevenueOfHost(@PathVariable int idHost){
        return iBillService.findRevenueOfHost(idHost);
    }
    @GetMapping("/findHouseByAccount/{idAccount}")
    public List<HouseDTO> findHouseByAccount(@PathVariable int idAccount) {
        return iHouseDTOService.findHouseDTOByAccount(idAccount);
    }
    @GetMapping("houseDetail/{houseId}")
    public ResponseEntity<HouseDTO> getHouseById(@PathVariable int houseId) {
        HouseDTO houseDTO = iHouseDTOService.findHouseDTOById(houseId);
        if (houseDTO != null) {
            return new ResponseEntity<>(houseDTO, HttpStatus.OK);
        } else {
            return null;
        }
    }

}
