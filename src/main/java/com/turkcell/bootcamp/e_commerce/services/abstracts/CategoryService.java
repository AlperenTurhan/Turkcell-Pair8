package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Category;
import com.turkcell.bootcamp.e_commerce.services.dtos.category.requests.AddCategoryRequest;

import java.util.List;

public interface CategoryService {

    void add(AddCategoryRequest request) throws Exception;
    void delete(int id) throws Exception;
    List<Category> getAll();
    Category getById(int id) throws Exception;
}
