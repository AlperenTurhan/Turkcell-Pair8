package com.turkcell.bootcamp.e_commerce.repositories.abstracts;



import com.turkcell.bootcamp.e_commerce.entities.Order;

import java.util.List;

public interface OrderRepository {
    void add(Order order);
    void delete(int id);
    void update(Order order);
    List<Order> getAll();
    Order getById(int id);
}
