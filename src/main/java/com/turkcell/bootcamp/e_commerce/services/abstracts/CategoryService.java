package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
}
