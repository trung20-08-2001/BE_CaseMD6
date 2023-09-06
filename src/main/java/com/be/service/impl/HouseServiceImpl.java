package com.be.service.impl;

import com.be.model.House;
import com.be.repository.IHouseRepository;
import com.be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements IHouseService {
    @Autowired
    IHouseRepository iHouseRepository;
    @Override
    public House save(House house) {
        return   iHouseRepository.save(house);
    }

    @Override
    public List<House> findHouseByAccount(int idAccount) {
        return iHouseRepository.findHouseByAccount(idAccount);
    }

    @Override
    public House findById(int id) {
        return iHouseRepository.findById(id).orElse(null);
    }

}
