package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Product;

import java.util.List;

public interface ProductService {
    void add(Product product) throws Exception;
    void delete(int id) throws Exception;
    int productAmountByCategoryName(String name) throws Exception;
    List<Product> getAll();
    Product getById(int id) throws Exception;
}
