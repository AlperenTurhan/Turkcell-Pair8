package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Payment_Methods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<Payment_Methods, Integer> {
    @Query("SELECT pm.name FROM Payment_Methods pm")
    List<String> findAllPaymentMethods();
}
