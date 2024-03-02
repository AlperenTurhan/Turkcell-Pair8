package com.turkcell.bootcamp.e_commerce.services.abstracts;


import com.turkcell.bootcamp.e_commerce.entities.Payment;

import java.util.List;

public interface PaymentService {
    void add(Payment payment) throws Exception;
    void delete(int id) throws Exception;
    void update(Payment payment) throws Exception;
    List<Payment> getAll();
    Payment getById(int id) throws Exception;
}
