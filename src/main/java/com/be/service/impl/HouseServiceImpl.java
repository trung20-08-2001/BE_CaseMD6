package com.be.service.impl;

import com.be.model.House;
import com.be.repository.IHouseRepository;
import com.be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements IHouseService {
    @Autowired
    IHouseRepository houseRepository;
    @Override
    public House save(House house) {
      return   houseRepository.save(house);
    }

}
