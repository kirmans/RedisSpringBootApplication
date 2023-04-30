package com.example.RedisProject.service;

import com.example.RedisProject.model.User;
import com.example.RedisProject.repository.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements  IUserService{
    @Autowired
    private IUserDao userDao;
    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<User> fetchAllUser() {
        return userDao.fetchAllUser();
    }

    @Override
    public User fetchUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }
}
