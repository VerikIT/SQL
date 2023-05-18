package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "devices")
@Data
public class Device {


    @ManyToOne
    private User user;
    private String deviceName;
    @Id
    @Column(unique = true)
    private int mac;
    }
