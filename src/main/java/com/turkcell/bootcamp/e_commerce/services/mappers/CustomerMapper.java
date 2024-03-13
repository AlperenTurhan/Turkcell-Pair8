package com.turkcell.bootcamp.e_commerce.services.mappers;

import com.turkcell.bootcamp.e_commerce.entities.Customer;
import com.turkcell.bootcamp.e_commerce.services.dtos.customer.requests.AddCustomerRequest;
import org.mapstruct.factory.Mappers;

public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer customerFromAddCustomerRequest(AddCustomerRequest request);
}
