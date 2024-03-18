package com.example.demo.services;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.models.Book;
import com.example.demo.models.Loan;
import com.example.demo.models.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LoanService loanService;
    @Autowired
    BookRepository bookRepository;

    // ADD user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // GET ALL users
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    // GET specific user by id
    public User getUserById(String id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    // DELETE user
    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return "User deleted";
    }


    // LOAN DBRef - add a loan to a user
    public User addLoanToUser(String userId, Loan loan) {
    String bookId = loan.getBookId();
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            Book foundBook = book.get();
            if (!foundBook.getAvailable()) {
                throw new EntityNotFoundException("This book is not available at the moment.");
            } else {
                foundBook.setAvailable(false);
                bookRepository.save(foundBook);
            }
        }
    User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    Loan savedLoans = loanService.saveLoan(loan);
    user.getLoans().add(savedLoans);
    return userRepository.save(user);
    }


    // LOAN DBRef - remove a loan from a user
    public User removeLoanFromUser(Loan loan) {
        Optional<User> user = userRepository.findById(loan.getUserId());
        if (user.isPresent()) {
            User foundUser = user.get();
            Optional<Loan> foundLoan = foundUser.getLoans().stream().filter(loan1 -> Objects.equals(loan1.getId(), loan.getId())).findFirst();
        if (foundLoan.isPresent()) {
            String bookId = loan.getBookId();
            Optional<Book> book = bookRepository.findById(bookId);
            if (book.isPresent()) {
                Book foundBook = book.get();
                foundBook.setAvailable(true);
                bookRepository.save(foundBook);
            }
            foundUser.getLoans().remove(foundLoan.get());
            return updateUser(foundUser.getId(), foundUser);
        }
        } else {
            throw new RuntimeException("User not found.");
        }
        return null;
    }

    // PUT - update user information
    public User updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    if (updatedUser.getFirstName() != null) {
                        existingUser.setFirstName(updatedUser.getFirstName());
                    }
                    if (updatedUser.getLastName() != null) {
                        existingUser.setLastName(updatedUser.getLastName());
                    }
                    if (updatedUser.getLoans() != null) {
                        existingUser.setLoans(updatedUser.getLoans());
                    }
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new EntityNotFoundException("User with id: " + id + " was not found."));
    }
}