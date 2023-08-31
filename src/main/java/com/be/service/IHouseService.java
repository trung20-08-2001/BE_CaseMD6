package com.be.service;

import com.be.model.House;
import com.be.model.dto.HouseDTO;

import java.util.HashMap;
import java.util.List;

public interface IHouseService {
    House save(House house);
    List<House> findHouseByAccount(int idAccount);
}
