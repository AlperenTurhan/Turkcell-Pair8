package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    void add(Customer customer);
    void delete(int id);
    void update(Customer customer);
    List<Customer> getAll();
    Customer getById(int id);
}
