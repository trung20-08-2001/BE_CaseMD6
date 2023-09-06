package com.be.service.impl;

import com.be.model.House;
import com.be.model.Image;
import com.be.model.dto.HouseDTO;
import com.be.repository.IHouseRepository;
import com.be.repository.IImageRepository;
import com.be.service.IHouseDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
@Service
public class HouseDTOServiceImpl implements IHouseDTOService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    IHouseRepository iHouseRepository;
    @Autowired
    IImageRepository iImageRepository;

    public List<HouseDTO> findHouseDTOs(List<House> houses){
        System.out.println(houses);
        List<HouseDTO> result = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++) {
            List<Image> images = iImageRepository.findImageByIdHouse(houses.get(i).getId());
            result.add(new HouseDTO(houses.get(i), images));
        }
        return result;
    }

    @Override
    public List<HouseDTO> findHouseDTOByAccount(int idAccount) {
        List<House> houses = iHouseRepository.findHouseByAccount(idAccount);
        return findHouseDTOs(houses);
    }

    @Override
    public List<HouseDTO> findTopHouseDTO() {
        List<House> houses = entityManager.createQuery("select h from House h order by h.numberOfHire desc ",House.class).setMaxResults(6).getResultList();
        return findHouseDTOs(houses);
    }
}
