package com.turkcell.bootcamp.e_commerce.controllers;

import com.turkcell.bootcamp.e_commerce.entities.Customer;
import com.turkcell.bootcamp.e_commerce.services.abstracts.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void add(@RequestBody Customer customer) throws Exception {
        customerService.add(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception {
        customerService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Customer customer) throws Exception {
        customerService.update(customer);
    }

    @GetMapping("/getall")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable(name = "id") int id) throws Exception {
        return customerService.getById(id);
    }
}
