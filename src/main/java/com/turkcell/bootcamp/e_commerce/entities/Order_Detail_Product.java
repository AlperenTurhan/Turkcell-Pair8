package com.turkcell.bootcamp.e_commerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table
@Entity
@Getter
@Setter
public class Order_Detail_Product {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    //ORDER_DETAIL_PRODUCT definition reason is M-to-M relationship between Order_Details and Products(?)
    @OneToMany(mappedBy = "order_details_id")
    private List<Order_Detail> order_details;

    @OneToMany(mappedBy = "product_id")
    private List<Product> products;
}
