package org.example.controller;

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

//    @GetMapping("/users/{name}")
//    public List<User> findByName(@PathVariable String name) {
//        return userService.findByName(name);
//    }

//    @PostMapping("/users")
//    public User save(@RequestBody User user) {
//        return userService.save(user);
//    }
}
