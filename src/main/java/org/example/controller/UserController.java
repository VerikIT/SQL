package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Device;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
    @GetMapping("/{userId}/devices")
    public List<Device> FindUserDevices(@PathVariable int userId ) {
        return userService.FindUserDevices(userId);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User FindById(@PathVariable Integer id) {
        return userService.findById(id);
    }
    @GetMapping("/{name}/find")
    public List<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }


}
