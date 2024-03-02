package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Product;

import java.util.List;

public interface ProductRepository {
    void add(Product product);
    void delete(int id);
    void update(Product product);
    List<Product> getAll();
    Product getById(int id);
}
