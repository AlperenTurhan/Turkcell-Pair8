package com.turkcell.bootcamp.e_commerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "addresses")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;
}
