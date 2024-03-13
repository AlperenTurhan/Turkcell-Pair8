package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Seller;
import com.turkcell.bootcamp.e_commerce.services.dtos.seller.requests.AddSellerRequest;

import java.util.List;

public interface SellerService{
    void add(AddSellerRequest request) throws Exception;
    void delete(int id) throws Exception;
   // void update(Seller seller) throws Exception;
    Seller getById(int id) throws Exception;
    List<Seller> getAll() throws Exception;
}
