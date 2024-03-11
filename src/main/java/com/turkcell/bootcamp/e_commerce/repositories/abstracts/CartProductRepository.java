package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Cart_Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<Cart_Products, Integer> {
}
