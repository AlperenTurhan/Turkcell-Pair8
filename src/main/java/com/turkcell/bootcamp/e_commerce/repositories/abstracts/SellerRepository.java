package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
