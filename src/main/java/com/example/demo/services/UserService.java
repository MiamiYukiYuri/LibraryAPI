package com.example.demo.services;

import com.example.demo.models.Loan;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LoanService loanService;

    // ADD user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // GET ALL users
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setBorrowedBooks(getUserLoans(user.getId()));
        }
        return users;
    }

    // GET specific user by id
    // Adds array list of borrowed books for user
    public User getUserById(String id) {
        User user = userRepository.findById(id).get();
        user.setBorrowedBooks(getUserLoans(id));
        return user;
    }

    // PUT - update user info
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // DELETE user
    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "User deleted";
    }

    // Array List of loans for a specific user
    private List<Loan> getUserLoans(String id) {
       return loanService.getLoanByUserId(id);
    }

}