package org.example.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
//@Transactional
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany (mappedBy = "user",fetch = FetchType.LAZY)
    private List<Device> devices=new ArrayList<>();
   // @Column(name = "first_name", unique = true)
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;


}
