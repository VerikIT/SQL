package org.example.service;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.model.Device;
import org.example.model.User;
import org.example.repository.DeviceRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
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

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public List<User> findByName(String name) {
        var data = userRepository.findByLike(name);
        return data;
    }

    public List<Device> FindUserDevices(Integer userId) {
        User user = findById(userId);
        return user.getDevices();
    }
}
