package org.example.service;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.model.Device;
import org.example.model.User;
import org.example.repository.DeviceRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;

    //    @Transactional
    public List<Device> findAll() {

        return deviceRepository.findAll();
    }

    @Transactional
    public Device save(Device device) {
        User user = userRepository.findById(device.getUserId()).orElse(null);
        device.setUser(user);
        return deviceRepository.save(device);

//        List<User> users = userRepository.findAll();
//        for (User user : users) {
//            if (user.getId() == device.getUserId()) {
//                device.setUser(user);
//                device = deviceRepository.save(device);
//                return device;
//            } else {
//                System.out.println("User not found");
//
//            }
//        }
//
//        return null;


    }

    public List<Device> findByName(String name) {
        //        var data = userRepository.findByFirstNameContaining(name);
        var data = deviceRepository.findByLike(name);
        return data;
    }

}
