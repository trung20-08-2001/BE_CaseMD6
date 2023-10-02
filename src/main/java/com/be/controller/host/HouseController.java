package com.be.controller.host;

import com.be.model.House;
import com.be.model.Image;
import com.be.model.dto.CustomPage;
import com.be.model.dto.HouseDTO;
import com.be.service.IHouseDTOService;
import com.be.service.IHouseService;
import com.be.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public CustomPage<HouseDTO> findAllHouse(@RequestParam int page, @RequestParam int size) {
        return iHouseDTOService.findAllHouseDTO(PageRequest.of(page,size, Sort.by("id").descending()));
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

    @GetMapping("/findTopSearch")
    public List<HouseDTO> findTopSearch(){
        return iHouseDTOService.findHouseDTOBySearchVolumes();
    }

}
