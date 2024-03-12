package com.turkcell.bootcamp.e_commerce.repositories;

import com.turkcell.bootcamp.e_commerce.entities.Order_Detail_Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailProductRepository extends JpaRepository<Order_Detail_Product, Integer> {
}
