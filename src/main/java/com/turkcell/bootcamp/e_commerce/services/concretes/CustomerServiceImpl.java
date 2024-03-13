package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.core.exception.types.BusinessException;
import com.turkcell.bootcamp.e_commerce.core.services.abstracts.MessageService;
import com.turkcell.bootcamp.e_commerce.core.services.constants.Messages;
import com.turkcell.bootcamp.e_commerce.entities.Customer;
import com.turkcell.bootcamp.e_commerce.repositories.CustomerRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.CustomerService;
import com.turkcell.bootcamp.e_commerce.services.dtos.customer.requests.AddCustomerRequest;
import com.turkcell.bootcamp.e_commerce.services.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private MessageService messageService;

    @Override
    public void add(AddCustomerRequest request) throws Exception {
        customersWithSameUserIdShouldNotExist(request.getUserId());
        Customer customer = CustomerMapper.INSTANCE.customerFromAddCustomerRequest(request);
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
        customerRepository.deleteById(id);
    }
    /*
    @Override
    public void update(Customer customer) throws Exception {
        if (!isIdExist(customer.getId())) {
            throw new Exception("There is no such a customer");
        }
        customerRepository.update(customer);
    }

     */

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
        return customerRepository.findById(id).get();
    }


    public boolean isIdExist(int id) {
        return customerRepository.existsById(id);
    }

    public void customersWithSameUserIdShouldNotExist(int userId) throws Exception {
        if (customerRepository.findByUserId(userId).isPresent()) {
            throw new Exception("This user already has a customer account.");
        }
    }

}
