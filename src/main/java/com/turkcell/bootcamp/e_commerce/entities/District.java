package com.turkcell.bootcamp.e_commerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "districts")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne()
    @JoinColumn(name="city_id")
    private City city;

    @OneToMany(mappedBy = "district")
    @JsonIgnore //TODO: remove after dto
    private List<Address> addresses;
}
