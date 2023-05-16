package org.example.dao;

import org.example.essence.User;

import java.util.List;

public interface UserDAO {
    void create(User user);

    List<User> getAll();

    User getById(int id);

    void update(User user);

    void removeById(int id);
}
