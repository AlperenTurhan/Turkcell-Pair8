package com.turkcell.bootcamp.e_commerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "order_details")
@Entity
@Getter
@Setter
public class Order_Detail {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "subtotal")
    private double subtotal;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "order_detail")
    private List< Order_Detail_Product> order_detail_products;

}
