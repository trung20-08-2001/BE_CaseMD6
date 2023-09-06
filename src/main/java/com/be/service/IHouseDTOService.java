package com.be.service;

import com.be.model.dto.HouseDTO;

import java.util.List;

public interface IHouseDTOService {
    List<HouseDTO> findHouseDTOByAccount(int idAccount);

    List<HouseDTO> findTopHouseDTO();
}
