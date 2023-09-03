package com.be.controller.host;

import com.be.model.Image;
import com.be.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    IImageService iImageService;
    @PostMapping("/save")
    public void save(@RequestBody List<Image> images){
         iImageService.save(images);
    }

    @PostMapping("/updateImageHouse/{idHouse}")
    public void updateImageHouse(@PathVariable int idHouse,@RequestBody List<Image> images){
        iImageService.updateImageHouse(idHouse,images);
    }

    @GetMapping("/findImageBanner")
    public List<Image> findImageBanner(){
        return iImageService.findImageBanner();
    }
}
