package com.turkcell.bootcamp.e_commerce.controllers;

import com.turkcell.bootcamp.e_commerce.entities.Category;
import com.turkcell.bootcamp.e_commerce.services.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping
    public void add(@RequestBody Category category) throws Exception{
        categoryService.add(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception{
        categoryService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Category category) throws Exception{
        categoryService.update(category);
    }

    @GetMapping("/getall")
    public List<Category> getAll() {
        return categoryService.getAll();

    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable(name = "id") int id) throws Exception {
        return categoryService.getById(id);
    }
}
