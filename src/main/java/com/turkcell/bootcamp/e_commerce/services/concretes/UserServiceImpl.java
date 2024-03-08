package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.entities.User;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.UserRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public void add(User user) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public void update(User user) throws Exception {

    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) throws Exception {
        return null;
    }
}
