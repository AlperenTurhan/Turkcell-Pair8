package com.turkcell.bootcamp.e_commerce.controllers;

import com.turkcell.bootcamp.e_commerce.entities.Category;
import com.turkcell.bootcamp.e_commerce.services.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
    private CategoryService categoryService;
    @GetMapping("/getall")
    public List<Category> getAll() {
        return categoryService.getAll();
    }
}
