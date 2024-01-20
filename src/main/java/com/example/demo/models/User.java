package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")

public class User {
    @Id
    private String id;
    private String fullName;
    private List borrowedBooks;


    // Tom konstruktor för att inte Postman ska balla ur
    public User() {
    }


    // GETTERS
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public List getBorrowedBooks() {
        return borrowedBooks;
    }

}