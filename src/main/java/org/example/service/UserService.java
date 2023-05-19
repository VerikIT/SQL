package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
    public String deleteById(int id) {
        userRepository.deleteById(id);
        return "deleted";
    }

    public List<User> findByName(String name) {
        var data = userRepository.findByLike(name);
        return data;
    }
}
