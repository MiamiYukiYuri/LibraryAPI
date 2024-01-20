package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")

public class User {
    @Id
    private String id;
    private String fullName;
    private String borrowedBooks;


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

    public String getBorrowedBooks() {
        return borrowedBooks;
    }
}
