package com.turkcell.bootcamp.e_commerce.entities;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class Cart_Products {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne()
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

}
