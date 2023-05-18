package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue
    private Integer id;
   // @Column(name = "first_name", unique = true)
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;
    @OneToMany (mappedBy = "userOne", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Device> devices;
}
