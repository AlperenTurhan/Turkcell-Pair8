package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Seller;

import java.util.List;

public interface SellerService{
    void add(Seller seller) throws Exception;
    void delete(int id) throws Exception;
    void update(Seller seller) throws Exception;
    Seller getById(int id) throws Exception;
    List<Seller> getAll() throws Exception;
}
