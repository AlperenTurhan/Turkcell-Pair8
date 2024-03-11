package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
    @Query("SELECT c.name, COUNT(DISTINCT s.id) AS sellerCount FROM Seller s JOIN s.user u JOIN u.addresses a JOIN a.district d JOIN d.city c GROUP BY c.name")
    List<Object[]> countSellersInCities();

}
