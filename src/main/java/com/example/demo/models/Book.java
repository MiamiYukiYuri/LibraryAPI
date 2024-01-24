package com.example.demo.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "books")

public class Book {
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Id
    private String id;
    private String title;
    private String author;
    private String description;
    private String pageAmount;
    private boolean available; // ???
    @CreatedDate
    private Date added;


    // Tom konstruktor för att inte Postman ska balla ur
    public Book() {
    }


    // GETTERS
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getPageAmount() {
        return pageAmount;
    }

    public Date getAdded() {
        return added;
    }

    public boolean getAvailable() {
        return available;
    }

}