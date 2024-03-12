package com.turkcell.bootcamp.e_commerce.repositories;

import com.turkcell.bootcamp.e_commerce.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("SELECT c.name, ci.name FROM Country c JOIN c.cities ci")
    List<Object[]> findCountryAndCityNames();
}
