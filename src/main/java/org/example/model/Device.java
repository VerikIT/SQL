package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "devices")
@Data
public class Device {
    @Id
//    @Column(name = "user_id")
    private Integer userId;
    private String deviceName;
    @Column(unique = true)
    private int mac;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User userOne;
}
