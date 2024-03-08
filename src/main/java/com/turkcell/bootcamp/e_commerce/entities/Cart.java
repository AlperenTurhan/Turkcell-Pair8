package com.turkcell.bootcamp.e_commerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Table
@Entity
@Data
public class Cart {
   // @OneToMany(mappedBy = "cart")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
   // private List<Cart_Products> cart_products;
    private int id;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "date")
    private Date date;
    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private List<Cart_Products> cart_products;


}
