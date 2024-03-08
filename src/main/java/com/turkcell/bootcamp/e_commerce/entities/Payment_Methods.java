package com.turkcell.bootcamp.e_commerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Table
@Entity
@Data
public class Payment_Methods {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "payment_methods")
    @JsonIgnore
    private List<Payment> payment;
}
