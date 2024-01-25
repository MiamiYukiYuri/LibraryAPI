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
    private List borrowedBooks;
    @CreatedDate
    private Date created;


    // Tom konstruktor för att inte Postman ska balla ur
    public User() {
    }

    // GETTERS
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public List getBorrowedBooks() {
        return borrowedBooks;
    }

    public Date getCreated() {
        return created;
    }
}
