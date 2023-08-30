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
    IImageRepository imageRepository;
    @Override
    public void save(Image image) {
        imageRepository.save(image);
    }
}
