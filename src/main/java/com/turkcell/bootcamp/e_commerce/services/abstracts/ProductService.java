package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.services.dtos.product.requests.AddProductRequest;
import com.turkcell.bootcamp.e_commerce.services.dtos.product.responses.ProductListResponse;
import com.turkcell.bootcamp.e_commerce.entities.Product;

import java.util.List;

public interface ProductService {
    void add(AddProductRequest request) throws Exception;
    void delete(int id) throws Exception;
    int productAmountByCategoryName(String name) throws Exception;
    List<ProductListResponse> getAll();
    Product getById(int id) throws Exception;
}
