package com.example.RedisProject.repository;

import com.example.RedisProject.model.User;
import io.lettuce.core.RedisURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao  implements  IUserDao{
    @Autowired
    private RedisTemplate redisTemplate;

    private static  final String KEY = "USER";
    @Override
    public boolean saveUser(User user) {
        try {
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> fetchAllUser() {
        List<User> users = redisTemplate.opsForHash().values(KEY);
        return users;
    }

    @Override
    public User getUserById(Long id) {
        User user = (User) redisTemplate.opsForHash().get(KEY, id.toString());
        return user;
    }

    @Override
    public boolean deleteUserById(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY, id.toString());
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

}
