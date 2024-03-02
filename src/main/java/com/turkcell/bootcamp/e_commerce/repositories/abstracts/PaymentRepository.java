package com.turkcell.bootcamp.e_commerce.repositories.abstracts;


import com.turkcell.bootcamp.e_commerce.entities.Payment;

import java.util.List;

public interface PaymentRepository {
    void add(Payment payment);
    void delete(int id);
    void update(Payment payment);
    List<Payment> getAll();
    Payment getById(int id);
}
