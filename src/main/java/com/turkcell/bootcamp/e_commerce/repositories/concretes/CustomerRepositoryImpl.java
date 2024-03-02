package com.turkcell.bootcamp.e_commerce.repositories.concretes;

import com.turkcell.bootcamp.e_commerce.entities.Customer;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    List<Customer> customers;

    public CustomerRepositoryImpl(){
        customers = new ArrayList<Customer>();
    }
    @Override
    public void add(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added: " + customer.getFullName());
    }

    @Override
    public void delete(int id) {
        customers.remove(getById(id));
        System.out.println("Customer deleted: " + id);
    }

    @Override
    public void update(Customer customer) {
        Customer oldCustomer = getById(customer.getId());
        oldCustomer.setFullName(customer.getFullName());
        oldCustomer.setPassword(customer.getPassword());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPhone(customer.getPhone());
        System.out.println("Customer updated: " + customer.getFullName());
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer getById(int id) {
        for(Customer customer: customers){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }
}
