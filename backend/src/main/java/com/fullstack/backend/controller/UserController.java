package com.fullstack.backend.controller;

import com.fullstack.backend.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User(1, "Atul", "Developer"));
        users.add(new User(2, "Rahul", "Tester"));
    }

    // GET all users
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    // GET user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        users.add(user);
        return "User added successfully";
    }

}
