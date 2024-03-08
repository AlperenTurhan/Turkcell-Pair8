package com.turkcell.bootcamp.e_commerce.controllers;

import com.turkcell.bootcamp.e_commerce.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/getall")
    public void getAll() {
        userService.getAll();
    }

    @PostMapping("/getbyid")
    public void getById(int id) throws Exception {
        userService.getById(id);
    }

    @PostMapping("/add")
    public void add() throws Exception {
        userService.add(null);
    }

    @PostMapping("/delete")
    public void delete(int id) throws Exception {
        userService.delete(id);
    }

    @PostMapping("/update")
    public void update() throws Exception {
        userService.update(null);
    }
}
