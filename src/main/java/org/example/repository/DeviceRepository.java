package org.example.repository;

import org.example.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
    @Query("SELECT d FROM Device d WHERE d.deviceName like %?1%")
    List<Device> findByLike(String deviceName);
}
