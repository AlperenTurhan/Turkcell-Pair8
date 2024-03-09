package com.turkcell.bootcamp.e_commerce.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Table(name="payments")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
 @Column(name = "id")
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 @Column(name="amount")
    private BigDecimal amount;//bak

 @Column(name="date")
    private Date date;//bak
    @ManyToOne()
    @JoinColumn(name="payment_method_id")
    private Payment_Methods paymentMethod;
    @ManyToOne()
    @JoinColumn(name="order_id")
    private Order order;





}
