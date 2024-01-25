package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // ADD user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // GET ALL users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET specific user by id
    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    // PUT - update user info
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // DELETE user
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}