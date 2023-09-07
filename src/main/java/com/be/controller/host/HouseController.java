package com.be.controller.host;

import com.be.model.House;
import com.be.model.Image;
import com.be.model.dto.HouseDTO;
import com.be.service.IHouseDTOService;
import com.be.service.IHouseService;
import com.be.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("houses")
public class HouseController {
    @Autowired
    private IHouseService iHouseService;
    @Autowired
    private IHouseDTOService iHouseDTOService;

    @PostMapping("/save")
    public House save(@RequestBody House house) {
        return iHouseService.save(house);
    }

    @GetMapping("/findHouseByAccount/{idAccount}")
    public List<HouseDTO> findHouseByAccount(@PathVariable int idAccount) {
        return iHouseDTOService.findHouseDTOByAccount(idAccount);
    }

    @GetMapping("/findTopHouse")
    public List<HouseDTO> findTopHouse() {
        return iHouseDTOService.findTopHouseDTO();
    }

    @GetMapping("/searchhouse/{idHouse}")
    public HouseDTO findById(@PathVariable int idHouse){
        return iHouseDTOService.findHouseDTOByHouse(idHouse);
    }


}
