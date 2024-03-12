package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.entities.Order;
import com.turkcell.bootcamp.e_commerce.repositories.OrderRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void add(Order order) throws Exception {


        orderRepository.save(order);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such an order");
        }
        orderRepository.deleteById(id);
    }


    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(int id) throws Exception {

        if (!isIdExist(id)) {
            throw new Exception("There is no such an order");
        }
        return orderRepository.getReferenceById(id);
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
