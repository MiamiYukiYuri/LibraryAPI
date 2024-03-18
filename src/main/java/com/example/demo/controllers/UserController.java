package com.example.demo.controllers;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.models.Loan;
import com.example.demo.models.User;
import com.example.demo.services.LoanService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    LoanService loanService;

    //POST - create a new user
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
    public String deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }



    // lägga till ett lån till en användare med objekt id-referens
    @PostMapping("/{userId}/loans")
    public ResponseEntity<User> addLoanToUser (@PathVariable String userId, @RequestBody Loan loan) {
        try {
    User updatedUser = userService.addLoanToUser(userId, loan);
    return ResponseEntity.ok(updatedUser);
    } catch (EntityNotFoundException entityNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }

    // ta bort ett lån från en användare
    @DeleteMapping("/{userId}/loans")
    public ResponseEntity<User> removeLoanFromUser (@PathVariable String userId, @RequestBody Loan loan) {
        try {
            User updateUser = userService.removeLoanFromUser(userId, loan);
            return ResponseEntity.ok(updateUser);
        } catch (EntityNotFoundException entityNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }
}