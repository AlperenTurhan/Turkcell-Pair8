package com.turkcell.bootcamp.e_commerce.services.concretes;


import com.turkcell.bootcamp.e_commerce.entities.Payment;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.PaymentRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;
    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    @Override
    public void add(Payment payment) throws Exception {
        if(isIdExist(payment.getId())){
            throw new Exception("This payment is already exist.");
        }


        paymentRepository.add(payment);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such an payment");
        }
        paymentRepository.delete(id);
    }

    @Override
    public void update(Payment payment) throws Exception {
        if (!isIdExist(payment.getId())) {
            throw new Exception("There is no such an payment");
        }
        paymentRepository.update(payment);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.getAll();
    }

    @Override
    public Payment getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such an payment");
        }
        return paymentRepository.getById(id);
    }
    public boolean isIdExist(int id) {
        for (Payment payment : getAll()) {
            if (payment.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
