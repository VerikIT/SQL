package org.example.repository;

import org.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.firstName like %?1%")
    List<User> findByLike(String firstName);

    //    List<User> findByFirstNameContaining(String firstName);
//
//
//    @Query("SELECT u FROM User u WHERE u.firstName like %?1%")
//    Page<User> findByLike(String firstName, Pageable pageable);
//
//    @Query(value = "SELECT * FROM users u WHERE u.first_name like %?1%",
//            nativeQuery = true)
//    List<User> findByLikeNative(String firstName);
}
