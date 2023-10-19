package com.be.service.impl;

import com.be.model.House;
import com.be.model.Image;
import com.be.model.dto.CustomPage;
import com.be.model.dto.HouseDTO;
import com.be.repository.IHouseRepository;
import com.be.repository.IImageRepository;
import com.be.service.IHouseDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
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
        List<HouseDTO> result = new ArrayList<>();
        for (int i = 0; i < houses.size(); i++) {
            List<Image> images = iImageRepository.findImageByIdHouse(houses.get(i).getId());
            if(images.isEmpty()) {
                Image image = new Image();
                image.setId(1);
                image.setType("HOUSE");
                image.setHouse(houses.get(i));
                image.setUrl("https://afdevinfo.com/wp-content/uploads/2017/10/thiet-ke-hinh-ngoi-nha-dep.jpg");
                images.add(image);
            }
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
        List<House> houses = entityManager.createQuery("select h from House h where h.status.id!=3 order by h.numberOfHire desc ",House.class).setMaxResults(3).getResultList();
        return findHouseDTOs(houses);
    }

    @Override
    public HouseDTO findHouseDTOByHouse(int idHouse) {
         House house=iHouseRepository.findById(idHouse);
         List<Image> images=iImageRepository.findImageByIdHouse(house.getId());
         return new HouseDTO(house,images);

    }

    @Override
    public CustomPage<HouseDTO> findAllHouseDTO(Pageable pageable) {
        Page<House> housePage=iHouseRepository.findAllHouse(pageable);
        List<HouseDTO> houseDTOs=findHouseDTOs(housePage.getContent());
        return new CustomPage<>(houseDTOs,housePage.getTotalPages(),housePage.getNumber());
    }

    @Override
    public List<HouseDTO> findHouseDTOBySearchVolumes() {
        List<House> houses=entityManager.createQuery("select h from House h order by h.searchVolume desc,h.numberOfHire desc ", House.class).setMaxResults(4).getResultList();
        return findHouseDTOs(houses);
    }

    @Override
    public List<HouseDTO> findHouseDTOPageSearch() {
       List<House> houses=iHouseRepository.getAllHouse();
       return findHouseDTOs(houses);
    }

    @Override
    public HouseDTO findHouseDTOById(int houseId) {
        House house = iHouseRepository.findById(houseId);
        List<Image> images = iImageRepository.findImageByIdHouse(house.getId());
        if(images.isEmpty()) {
            Image image = new Image();
            image.setId(1);
            image.setType("HOUSE");
            image.setHouse(house);
            image.setUrl("https://afdevinfo.com/wp-content/uploads/2017/10/thiet-ke-hinh-ngoi-nha-dep.jpg");
            images.add(image);
        }
        return new HouseDTO(house, images);
    }

    @Override
    public House saveHouse(House house) {
        return iHouseRepository.save(house);
    }
}
