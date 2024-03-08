package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.User;

import java.util.List;

public interface UserService {
    void add(User user) throws Exception;
    void delete(int id) throws Exception;
    void update(User user) throws Exception;
    List<User> getAll();
    User getById(int id) throws Exception;
}
