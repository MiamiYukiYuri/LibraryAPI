package com.example.demo.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "users")

public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private List<Loan> borrowedBooks;
    @CreatedDate
    private Date created;


    // Empty constructor
    public User() {
    }

    // SETTER AND GETTER for borrowedBooks
    public List<Loan> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void setBorrowedBooks(List<Loan> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }


    // GETTERS
    public String getId() {
        return id;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getCreated() { return created; }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", created=" + created +
                '}';
    }
}