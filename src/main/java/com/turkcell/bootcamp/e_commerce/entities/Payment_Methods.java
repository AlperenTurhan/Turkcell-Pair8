package com.turkcell.bootcamp.e_commerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="payments_methods")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment_Methods {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "paymentMethod")
    @JsonIgnore
    private List<Payment> payment;
}
