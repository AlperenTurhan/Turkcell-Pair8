package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Order;

import java.util.List;

public interface OrderService {
    void add(Order order) throws Exception;
    void delete(int id) throws Exception;

    List<Order> getAll();
    Order getById(int id) throws Exception;
}
