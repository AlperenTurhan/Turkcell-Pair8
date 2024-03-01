package com.turkcell.bootcamp.e_commerce.controllers;


import com.turkcell.bootcamp.e_commerce.entities.Category;
import com.turkcell.bootcamp.e_commerce.entities.Order;
import com.turkcell.bootcamp.e_commerce.services.abstracts.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public void add(@RequestBody Order order) throws Exception{
        orderService.add(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception{
        orderService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Order order) throws Exception{
        orderService.update(order);
    }

    @GetMapping("/getall")
    public List<Order> getAll() {
        return orderService.getAll();

    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable(name = "id") int id) throws Exception {
        return orderService.getById(id);
    }
}
