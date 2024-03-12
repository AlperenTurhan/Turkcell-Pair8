package com.turkcell.bootcamp.e_commerce.repositories;


import com.turkcell.bootcamp.e_commerce.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
