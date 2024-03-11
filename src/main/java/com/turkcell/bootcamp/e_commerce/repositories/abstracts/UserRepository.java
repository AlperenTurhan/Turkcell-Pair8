package com.turkcell.bootcamp.e_commerce.repositories.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT COUNT(u) FROM User u")
    int countAllUsers();
    @Query("SELECT u FROM User u WHERE u.last_name LIKE %:name")
    List<User> findUsersWithLastNameEndingWith(String name);
    @Query("SELECT COUNT(DISTINCT u.id) FROM User u JOIN u.addresses a JOIN a.district d JOIN d.city c WHERE c.name = :name")
    Long countUsersWithAddressIn(String name);
}
