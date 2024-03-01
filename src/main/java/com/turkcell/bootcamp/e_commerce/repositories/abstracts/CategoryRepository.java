package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Category;

import java.util.List;

public interface CategoryRepository {
    void add(Category category);
    void delete(int id);
    void update(Category category);
    List<Category> getAll();
    Category getById(int id);
}
