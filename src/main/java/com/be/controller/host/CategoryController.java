package com.be.controller.host;

import com.be.model.Category;
import com.be.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/findAll")
    public List<Category> findAll(){
        return categoryService.getAll();
    }
}
