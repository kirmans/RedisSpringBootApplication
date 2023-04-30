package com.example.RedisProject.repository;

import com.example.RedisProject.model.User;

import java.util.List;

public interface IUserDao {
    boolean saveUser(User user);

    List<User> fetchAllUser();

    User getUserById(Long id);

    boolean deleteUserById(Long id);

}
