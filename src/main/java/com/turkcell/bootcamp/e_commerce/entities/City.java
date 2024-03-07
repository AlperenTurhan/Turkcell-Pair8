package com.turkcell.bootcamp.e_commerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "cities")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "city")
    @JsonIgnore//TODO: remove after dto
    private List<District> districts;

    @ManyToOne()
    @JoinColumn(name="country_id")
    private Country country;
}
