package com.turkcell.bootcamp.e_commerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "order_details_products")
@Entity
@Getter
@Setter
public class Order_Detail_Product {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    //ORDER_DETAIL_PRODUCT definition reason is M-to-M relationship between Order_Details and Products(?)
    @ManyToOne
    @JoinColumn(name = "order_details_id")
    private Order_Detail order_detail;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product order_product;
}
