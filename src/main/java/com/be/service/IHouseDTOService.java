package com.be.service;

import com.be.model.House;
import com.be.model.dto.CustomPage;
import com.be.model.dto.HouseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IHouseDTOService {
    List<HouseDTO> findHouseDTOByAccount(int idAccount);
    List<HouseDTO> findTopHouseDTO();
    HouseDTO findHouseDTOByHouse(int idHouse);
    CustomPage<HouseDTO> findAllHouseDTO(Pageable pageable);
    List<HouseDTO> findHouseDTOBySearchVolumes();
    List<HouseDTO> findHouseDTOPageSearch();
    HouseDTO findHouseDTOById(int houseId);
    House saveHouse(House house);
}
