package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class UserController {

    @Autowired
    UserService userService;

    //POST - create a new user  http://localhost:8080/api/user
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // GET ALL users
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET user by userId
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    // PUT - update user information
    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    // DELETE user
    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}