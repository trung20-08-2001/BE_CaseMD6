package com.be.controller;

import com.be.model.Image;
import com.be.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    IImageService iImageService;
    @PostMapping("/save")
    public void save(@RequestBody Image image){
         iImageService.save(image);
    }
}
