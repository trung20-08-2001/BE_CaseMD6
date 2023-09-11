package com.be.controller.host;

import com.be.model.House;
import com.be.model.Image;
import com.be.model.dto.HouseDTO;
import com.be.service.IAccountService;
import com.be.service.IHouseService;
import com.be.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("houses")
public class HouseController {
    @Autowired
    private IHouseService iHouseService;
    @Autowired
    private IImageService iImageService;

    @PostMapping("/save")
    public House save(@RequestBody House house) {
        return iHouseService.save(house);
    }

    @GetMapping("/findHouseByAccount/{idAccount}")
    public List<HouseDTO> findHouseByAccount(@PathVariable int idAccount) {
        List<HouseDTO> result = new ArrayList();
        List<House> houses = iHouseService.findHouseByAccount(idAccount);
        for (int i = 0; i < houses.size(); i++) {
            List<Image> images = iImageService.findImageByHouse(houses.get(i).getId());
            result.add(new HouseDTO(houses.get(i), images));
        }
        return result;
    }

    @GetMapping("/getAllHouseByName/{nameHouse}/{accountId}")
    public ResponseEntity<List<HouseDTO>> getHousesByName(@PathVariable String nameHouse,
                                                          @PathVariable int accountId) {
        List<HouseDTO> result = new ArrayList<>();
        List<House> houses = iHouseService.findAllByName(nameHouse, accountId);
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (int i = 0; i < houses.size(); i++) {
            List<Image> images = iImageService.findImageByHouse(houses.get(i).getId());
            result.add(new HouseDTO(houses.get(i), images));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getAllHouseByNameAndStatus/{name}/{statusId}/{accountId}")
    public ResponseEntity<List<HouseDTO>> getHousesByName(@PathVariable String name,
                                                          @PathVariable int accountId,
                                                          @PathVariable int statusId) {
        List<HouseDTO> result = new ArrayList<>();
        List<House> houses = iHouseService.findAllByNameAndStatus(name, statusId, accountId);
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (int i = 0; i < houses.size(); i++) {
            List<Image> images = iImageService.findImageByHouse(houses.get(i).getId());
            result.add(new HouseDTO(houses.get(i), images));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getAllHouseByStatus/{statusId}/{accountId}")
    public ResponseEntity<List<HouseDTO>> getHousesByStatus(@PathVariable int statusId,
                                                            @PathVariable int accountId) {
        List<HouseDTO> result = new ArrayList<>();
        List<House> houses = iHouseService.findAllByStatus(statusId, accountId);
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (int i = 0; i < houses.size(); i++) {
            List<Image> images = iImageService.findImageByHouse(houses.get(i).getId());
            result.add(new HouseDTO(houses.get(i), images));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("houseDetail/{houseId}")
    public ResponseEntity<HouseDTO> getHouseById(@PathVariable int houseId) {
        HouseDTO houseDTO = iHouseService.findById(houseId);
        if (houseDTO != null) {
            return new ResponseEntity<>(houseDTO, HttpStatus.OK);
        } else {
            return null;
        }
    }

}
