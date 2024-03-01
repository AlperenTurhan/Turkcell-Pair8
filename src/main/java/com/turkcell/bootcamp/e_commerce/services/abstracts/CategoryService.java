package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category) throws Exception;
    void delete(int id) throws Exception;
    void update(Category category) throws Exception;
    List<Category> getAll();
    Category getById(int id) throws Exception;
}
