package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    void add(Customer customer);
    void delete(int id);
    void update(Customer customer);
    List<Customer> getAll();
    Customer getById(int id);
}
