package com.turkcell.bootcamp.e_commerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.sql.Date;


@Table(name = "orders")
@Entity
@Getter
@Setter
public class Order {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    @Column(name = "total_amount")
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "order_detail_id")
    private Order_Detail order_detail;
}
