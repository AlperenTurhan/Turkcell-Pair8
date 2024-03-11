package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Payment_Methods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<Payment_Methods, Integer> {
}
