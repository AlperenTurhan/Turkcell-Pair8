package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT COUNT(*) AS product_count FROM products p JOIN categories c ON p.category_id = c.id WHERE c.name = :categoryName", nativeQuery = true)
    int countProductsByCategoryName(@Param("categoryName") String categoryName);

    Optional<Product> findByName(String name);

}
