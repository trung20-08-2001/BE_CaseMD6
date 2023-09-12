package com.be.service.impl;

import com.be.model.House;
import com.be.model.Image;
import com.be.model.dto.HouseDTO;
import com.be.model.dto.HouseDTO;
import com.be.repository.IHouseRepository;
import com.be.service.IHouseService;
import com.be.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements IHouseService {
    @Autowired
    IHouseRepository iHouseRepository;
    @Autowired
    IImageService iImageService;

    @Override
    public House save(House house) {
        return iHouseRepository.save(house);
    }

    @Override
    public List<House> findHouseByAccount(int idAccount) {
        return iHouseRepository.findHouseByAccount(idAccount);
    }

    @Override
    public House findById1(int id) {
        return iHouseRepository.findById(id);
    }

    @Override
    public List<House> findAllByName(String nameHouse, int accountId) {

        return iHouseRepository.findAllByName(nameHouse, accountId);
    }

    @Override
    public List<House> findAllByNameAndStatus(String nameHouse, int statusId, int accountId) {
        return iHouseRepository.findAllByNameAndStatus(nameHouse, statusId, accountId);
    }

    @Override
    public List<House> findAllByStatus(int statusId, int accountId) {
        return iHouseRepository.findAllByStatus(statusId, accountId);
    }

    @Override
    public HouseDTO findById(int houseId) {
        House house = iHouseRepository.findById(houseId);
        if (house != null) {
            List<Image> images = iImageService.findImageByHouse(houseId);
            HouseDTO houseDTO = new HouseDTO(house,images);
            return houseDTO;
        } else {
            return null;
        }
    }



}
