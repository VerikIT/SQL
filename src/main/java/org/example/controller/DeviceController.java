package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Device;
import org.example.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;
    @GetMapping("/devices")
    public List<Device> findAll(){
        return deviceService.findAll();
    }
    @PostMapping("/devices")
    public Device save(@RequestBody Device device){

        return deviceService.save(device);
    }
        @GetMapping("/devices/{name}")
    public List<Device> findByName(@PathVariable String name) {
        return deviceService.findByName(name);
    }

}
