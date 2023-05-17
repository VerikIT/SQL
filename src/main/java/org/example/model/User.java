package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

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
}
