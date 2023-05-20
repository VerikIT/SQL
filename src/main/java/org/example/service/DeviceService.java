package org.example.service;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.model.Device;
import org.example.repository.DeviceRepository;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;


    public List<Device> findAll() {
        return deviceRepository.findAll();
    }


    public Device save(Device device) {
        return deviceRepository.save(device);
    }
    public Device saveById(Device device, int userId) {
        device.setUser(userRepository.findById(userId).orElse(null));
        return deviceRepository.save(device);
    }
    public void deleteById(int id) {

       deviceRepository.deleteById(id);
    }
    public Device findById(int id){
        return deviceRepository.findById(id).orElse(null);
    }

    public List<Device> findByName(String name) {
        var data = deviceRepository.findByLike(name);
        return data;
    }

}
