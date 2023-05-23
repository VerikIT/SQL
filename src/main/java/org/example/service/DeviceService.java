package org.example.service;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.model.Device;
import org.example.model.User;
import org.example.repository.DeviceRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
//@RequiredArgsConstructor
@Transactional
public class DeviceService {
    private static final String USER_SERVICE_URL = "http://localhost:8181/users/";

    private final DeviceRepository deviceRepository;

    private RestTemplate restTemplate;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository, RestTemplate restTemplate) {
        this.deviceRepository = deviceRepository;
        this.restTemplate = restTemplate;
    }


    public List<Device> findAll() {
        return deviceRepository.findAll();
    }


    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    public Device saveById(Device device, int userId) {
        User user = restTemplate.getForObject(USER_SERVICE_URL + userId, User.class);
        if (user != null) {
            device.setUser(user);
            return deviceRepository.save(device);
        }
        return null;
    }

    public void deleteById(int id) {
        deviceRepository.deleteById(id);
    }

    public Device findById(int id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public List<Device> findByName(String name) {
        return deviceRepository.findByLike(name);
    }

}
