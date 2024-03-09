package com.turkcell.bootcamp.e_commerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="cart_products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
