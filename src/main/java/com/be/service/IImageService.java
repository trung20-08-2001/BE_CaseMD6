package com.be.service;

import com.be.model.Image;

import java.util.List;

public interface IImageService {
    List<Image> save(List<Image> images);
    List<Image> findImageByHouse(int idHouse);
    void updateImageHouse(int idHouse,List<Image> images);
}

