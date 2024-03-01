package com.turkcell.bootcamp.e_commerce.repositories.concretes;


import com.turkcell.bootcamp.e_commerce.entities.Order;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    List<Order> orders;
    public OrderRepositoryImpl(){
        orders = new ArrayList<Order>();
    }
    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public void delete(int id) {
        orders.remove(getById(id));
    }

    @Override
    public void update(Order order) {
        Order oldOrder = getById(order.getId());
        oldOrder.setCustomerId(order.getCustomerId());
        oldOrder.setDate(order.getDate());
        oldOrder.setStatus(order.getStatus());
        oldOrder.setTotalAmount(order.getTotalAmount());
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public Order getById(int id) {
        for(Order order: orders){
            if(order.getId() == id){
                return order;
            }
        }
        return null;
    }
}
