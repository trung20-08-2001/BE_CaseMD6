package com.be.controller;

import com.be.model.House;
import com.be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/houses")
public class HouseController {
    @Autowired
    private IHouseService houseService;

    @PostMapping("/save")
    public void save(@RequestBody House house) {
        houseService.save(house);
    }
}
