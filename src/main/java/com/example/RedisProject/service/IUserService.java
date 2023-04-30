package com.example.RedisProject.service;

import com.example.RedisProject.model.User;

import java.util.List;

public interface IUserService {
    boolean saveUser(User user);

    List<User> fetchAllUser();

    User fetchUserById(Long id);

    boolean deleteUserById(Long id);

}
