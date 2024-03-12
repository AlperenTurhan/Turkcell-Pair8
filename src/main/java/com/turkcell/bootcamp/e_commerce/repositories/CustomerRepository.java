package com.turkcell.bootcamp.e_commerce.repositories;

import com.turkcell.bootcamp.e_commerce.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
