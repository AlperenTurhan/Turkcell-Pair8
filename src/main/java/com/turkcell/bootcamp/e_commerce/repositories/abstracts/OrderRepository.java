package com.turkcell.bootcamp.e_commerce.repositories.abstracts;



import com.turkcell.bootcamp.e_commerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
