package org.example.dao;

import org.example.essence.Device;
import org.example.essence.User;

import java.util.List;

public interface DeviceDAO {
    void create(Device device);

    List<Device> getAll();

    Device getByMAC(int MAC);

    void update(Device device);

    void removeByMAC(int MAC);
}
