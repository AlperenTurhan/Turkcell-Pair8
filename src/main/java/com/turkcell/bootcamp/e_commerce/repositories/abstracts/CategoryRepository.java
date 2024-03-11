package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
        List<Category> getAll();
        @Query("SELECT c FROM Category c LEFT JOIN c.products p WHERE p IS NULL")
        List<Category> findCategoriesWithoutProducts();
}