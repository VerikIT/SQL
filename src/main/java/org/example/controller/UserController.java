package org.example.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User FindById(@PathVariable Integer id) {
        return userService.findById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        return userService.deleteById(id);
    }
    @GetMapping("/users/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }
}
