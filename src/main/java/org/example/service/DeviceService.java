package org.example.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.model.Device;
import org.example.model.User;
import org.example.repository.DeviceRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Transactional
    public Device save(Device device) {
        User user = userRepository.findById(device.getUserId()).orElse(null);
        device.setUser(user);
        return deviceRepository.save(device);

    }


    public List<Device> findByName(String name) {
        var data = deviceRepository.findByLike(name);
        return data;
    }

}
