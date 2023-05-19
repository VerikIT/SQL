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
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Transactional
   public List<Device> findAll(){

       return deviceRepository.findAll();
   }
   public Device save(Device device) {
       device=deviceRepository.save(device);
       return device;
   }
        public List<Device> findByName(String name) {
        //        var data = userRepository.findByFirstNameContaining(name);
        var data = deviceRepository.findByLike(name);
        return data;
    }

}
