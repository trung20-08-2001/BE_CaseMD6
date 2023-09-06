package com.be.controller.host;

import com.be.model.House;
import com.be.model.Image;
import com.be.model.dto.HouseDTO;
import com.be.service.IHouseService;
import com.be.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
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
      return  iHouseService.save(house);
    }

    @GetMapping("/findHouseByAccount/{idAccount}")
    public List<HouseDTO> findHouseByAccount(@PathVariable int idAccount){
        List<HouseDTO> result = new ArrayList();
        List<House> houses= iHouseService.findHouseByAccount(idAccount);
        for(int i=0; i<houses.size(); i++){
            List<Image> images=iImageService.findImageByHouse(houses.get(i).getId());
            result.add(new HouseDTO(houses.get(i), images));
        }
        return result;
    }

    @GetMapping("/searchhouse/{id}")
    public House findById(@PathVariable int id){
        return iHouseService.findById(id);
    }

}
