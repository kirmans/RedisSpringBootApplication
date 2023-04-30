package com.example.RedisProject.controller;

import com.example.RedisProject.model.User;
import com.example.RedisProject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        boolean result = userService.saveUser(user);
        if(result)
            return ResponseEntity.ok("User Created Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> fetchAllUser() {
        List<User> users;
        users = userService.fetchAllUser();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        User user = userService.fetchUserById(id);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        boolean result = userService.deleteUserById(id);
        if(result)
            return ResponseEntity.ok("User deleted Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
