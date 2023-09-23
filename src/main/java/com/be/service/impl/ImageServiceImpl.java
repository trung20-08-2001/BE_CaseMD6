package com.be.service.impl;

import com.be.model.Image;
import com.be.repository.IImageRepository;
import com.be.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements IImageService {
    @Autowired
    IImageRepository iImageRepository;
    @Override
    public List<Image> save(List<Image> images) {
        return iImageRepository.saveAll(images);
    }

    @Override
    public List<Image> findImageByHouse(int idHouse) {
        return iImageRepository.findImageByIdHouse(idHouse);
    }

    @Override
    public void updateImageHouse(int idHouse,List<Image> images) {
        iImageRepository.deleteAllInBatch(idHouse);
        iImageRepository.saveAll(images);
    }
}
