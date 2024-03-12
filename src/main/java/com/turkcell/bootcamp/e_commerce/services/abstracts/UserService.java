package com.turkcell.bootcamp.e_commerce.services.abstracts;

import com.turkcell.bootcamp.e_commerce.entities.User;
import com.turkcell.bootcamp.e_commerce.services.dtos.user.requests.AddUserRequest;
import com.turkcell.bootcamp.e_commerce.services.dtos.user.responses.UserListResponse;

import java.util.List;

public interface UserService {
    void add(AddUserRequest request) throws Exception;
    void delete(int id) throws Exception;
    void update(User user) throws Exception;
    List<UserListResponse> getAll();
    User getById(int id) throws Exception;
}
