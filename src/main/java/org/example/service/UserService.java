package org.example.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

//    @Transactional
    public List<User> findAll() {

        return userRepository.findAll();
    }
//
//    @Transactional // ?
    public User save(User user) {
        user = userRepository.save(user);
//       user.setLastName("booboo!");
//       user.setFirstName("aaa!");
        return user;
    }
//
//    public List<User> findByName(String name)
//    {
//        var data = userRepository.findByFirstNameContaining(name);
//        return data;
//    }
}
