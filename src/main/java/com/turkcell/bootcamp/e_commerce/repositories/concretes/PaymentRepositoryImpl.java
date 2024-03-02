package com.turkcell.bootcamp.e_commerce.repositories.concretes;


import com.turkcell.bootcamp.e_commerce.entities.Payment;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
    List<Payment> payments;
    public PaymentRepositoryImpl(){
        payments = new ArrayList<Payment>();
    }
    @Override
    public void add(Payment payment) {
        payments.add(payment);
    }

    @Override
    public void delete(int id) {
        payments.remove(getById(id));
    }

    @Override
    public void update(Payment payment) {
        Payment oldPayment = getById(payment.getId());
        oldPayment.setDate(payment.getDate());
        oldPayment.setAmount(payment.getAmount());
        oldPayment.setOrderId(payment.getOrderId());
        oldPayment.setPaymentMethodId(payment.getPaymentMethodId());
    }

    @Override
    public List<Payment> getAll() {
        return payments;
    }

    @Override
    public Payment getById(int id) {
        for(Payment payment: payments){
            if(payment.getId() == id){
                return payment;
            }
        }
        return null;
    }
}
