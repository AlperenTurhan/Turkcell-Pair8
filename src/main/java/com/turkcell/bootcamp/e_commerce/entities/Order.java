package com.turkcell.bootcamp.e_commerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Date;


@Table(name = "Orders")
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
    private int totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    private Order_Detail order_detail;
}
