package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
