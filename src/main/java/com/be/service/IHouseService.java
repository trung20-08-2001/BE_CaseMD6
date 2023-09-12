package com.be.service;

import com.be.model.House;
import com.be.model.dto.HouseDTO;

import java.util.HashMap;
import java.util.List;

public interface IHouseService {
    House save(House house);

    List<House> findHouseByAccount(int idAccount);

    House findById1(int id);
    List<House> findAllByName(String nameHouse, int accountId);

    List<House> findAllByNameAndStatus(String nameHouse, int statusId, int accountId);

    List<House> findAllByStatus(int statusId, int accountId);
    HouseDTO findById(int houseId);
}
