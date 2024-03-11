package com.turkcell.bootcamp.e_commerce.controllers;


import com.turkcell.bootcamp.e_commerce.entities.Payment;
import com.turkcell.bootcamp.e_commerce.services.abstracts.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @PostMapping
    public void add(@RequestBody Payment payment) throws Exception{
        paymentService.add(payment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception{
        paymentService.delete(id);
    }
    /*
    @PutMapping("/update")
    public void update(@RequestBody Payment payment) throws Exception{
        paymentService.update(payment);
    }

     */

    @GetMapping("/getall")
    public List<Payment> getAll() {
        return paymentService.getAll();

    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable(name = "id") int id) throws Exception {
        return paymentService.getById(id);
    }
}
