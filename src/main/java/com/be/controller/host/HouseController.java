package com.be.controller.host;

import com.be.model.dto.CustomPage;
import com.be.model.dto.HouseDTO;
import com.be.service.IHouseDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("houses")
public class HouseController {
    @Autowired
    private IHouseDTOService iHouseDTOService;

    @GetMapping("/findTopHouse")
    public List<HouseDTO> findTopHouse() {
        return iHouseDTOService.findTopHouseDTO();
    }
    @GetMapping("/searchHouse/{idHouse}")
    public HouseDTO findById(@PathVariable int idHouse){
        return iHouseDTOService.findHouseDTOByHouse(idHouse);
    }

    @GetMapping("/findAllHouse")
    public CustomPage<HouseDTO> findAllHouse(@RequestParam int page, @RequestParam int size) {
        return iHouseDTOService.findAllHouseDTO(PageRequest.of(page,size, Sort.by("id").descending()));
    }
    @GetMapping ("/findHousePageSearch")
    public List<HouseDTO> findHouseDTOPageSearch(){
        return iHouseDTOService.findHouseDTOPageSearch();
    }

    @GetMapping("/findTopSearch")
    public List<HouseDTO> findTopSearch(){
        return iHouseDTOService.findHouseDTOBySearchVolumes();
    }

}
