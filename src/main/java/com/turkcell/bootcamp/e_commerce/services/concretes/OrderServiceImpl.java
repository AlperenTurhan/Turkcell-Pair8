package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.entities.Order;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.OrderRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void add(Order order) throws Exception {
        if(isIdExist(order.getId())){
            throw new Exception("This order is already exist.");
        }


        orderRepository.add(order);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such an order");
        }
        orderRepository.delete(id);
    }

    @Override
    public void update(Order order) throws Exception {
        if (!isIdExist(order.getId())) {
            throw new Exception("There is no such an order");
        }
        orderRepository.update(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such an order");
        }
        return orderRepository.getById(id);
    }
    public boolean isIdExist(int id) {
        for (Order order : getAll()) {
            if (order.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
