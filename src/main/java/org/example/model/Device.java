package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "devices")
@Data
public class Device {
    @Id
    private Integer userId;
    private String deviceName;
    private int MAC;
    @ManyToOne
    private User user;
}
