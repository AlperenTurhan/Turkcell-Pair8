package com.turkcell.bootcamp.e_commerce.repositories;

import com.turkcell.bootcamp.e_commerce.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
