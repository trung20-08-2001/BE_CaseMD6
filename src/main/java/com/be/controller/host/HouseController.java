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

    @GetMapping("/searchhouse/{id}")
    public House findById(@PathVariable int id){
        return iHouseService.findById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseDTO> getHouseWithImages(@PathVariable int id) {
        Optional<House> houseOptional = Optional.ofNullable(iHouseService.findById(id));
        if (!houseOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        House house = houseOptional.get();
        List<Image> images = iImageService.findImageByHouse(id);
        HouseDTO houseDTO = new HouseDTO(house,images);
        houseDTO.setHouse(house);
        houseDTO.setImages(images);

        return ResponseEntity.ok(houseDTO);
    }
}
