package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
