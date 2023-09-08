package com.be.controller.host;

import com.be.model.House;
import com.be.model.dto.HouseDTO;
import com.be.service.IHouseDTOService;
import com.be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("houses")
public class HouseController {
    @Autowired
    private IHouseService iHouseService;
    @Autowired
    private IHouseDTOService iHouseDTOService;
    @Autowired
    private IImageService iImageService;

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


    @GetMapping("/findAllHouse")
    public List<HouseDTO> findAllHouse() {
        return iHouseDTOService.findAllHouseDTO();
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
        List<House> houses = iHouseService.findAllByNameAndStatus(name, statusId,accountId);
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
        List<House> houses = iHouseService.findAllByStatus(statusId,accountId);
        if (houses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (int i = 0; i < houses.size(); i++) {
            List<Image> images = iImageService.findImageByHouse(houses.get(i).getId());
            result.add(new HouseDTO(houses.get(i), images));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
