package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Device;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
//@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private static final String DEVICE_SERVICE_URL = "http://localhost:8181/devices/";
    private RestTemplate restTemplate;
    @Autowired

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

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
       return userRepository.findByLike(name);
    }

    public List<Device> FindUserDevices(Integer userId) {

        return findById(userId).getDevices();
    }
}
