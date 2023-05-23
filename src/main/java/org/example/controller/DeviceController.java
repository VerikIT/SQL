package org.example.controller;

import org.example.model.Device;
import org.example.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")

public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<Device> findAll() {
        return deviceService.findAll();
    }

    @PostMapping
    public Device save(@RequestBody Device device) {
        return deviceService.save(device);
    }

    @PostMapping("/{userId}/userId")
    public Device save(@PathVariable int userId, @RequestBody Device device) {
        return deviceService.saveById(device, userId);
    }

    @GetMapping("/{id}")
    public Device findById(@PathVariable int id) {
        return deviceService.findById(id);
    }

    @GetMapping("/{name}/find")
    public List<Device> findByName(@PathVariable String name) {
        return deviceService.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        deviceService.deleteById(id);
    }

}
