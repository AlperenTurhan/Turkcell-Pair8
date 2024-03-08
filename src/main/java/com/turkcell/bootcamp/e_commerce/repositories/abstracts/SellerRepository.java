package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
    void add(Seller seller);
    void delete(int id);
    void update(Seller seller);
    Seller getById(int id);

    List<Seller> getAll();
}
