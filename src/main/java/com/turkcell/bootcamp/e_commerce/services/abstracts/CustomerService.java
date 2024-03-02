package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Customer;

import java.util.List;

public interface CustomerService {
    void add(Customer customer) throws Exception;
    void delete(int id) throws Exception;
    void update(Customer customer) throws Exception;
    List<Customer> getAll();
    Customer getById(int id) throws Exception;
}
