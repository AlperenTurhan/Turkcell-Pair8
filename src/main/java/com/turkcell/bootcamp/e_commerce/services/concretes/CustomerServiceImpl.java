package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.entities.Customer;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.CustomerRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public void add(Customer customer) throws Exception {
        if(isIdExist(customer.getId())){
            throw new Exception("This customer already exists.");
        }
        customerRepository.add(customer);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a customer");
        }
        customerRepository.delete(id);
    }

    @Override
    public void update(Customer customer) throws Exception {
        if (!isIdExist(customer.getId())) {
            throw new Exception("There is no such a customer");
        }
        customerRepository.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a customer");
        }
        return customerRepository.getById(id);
    }

    public boolean isIdExist(int id) {
        for (Customer customer : getAll()) {
            if (customer.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
