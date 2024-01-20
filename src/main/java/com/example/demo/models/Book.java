package com.example.demo.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "books")

public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String pageAmount;
    private boolean available; // true, false ???
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

    public String getPageAmount() {
        return pageAmount;
    }

    public Date getAdded() {
        return added;
    }

    public boolean isAvailable() {
        return available;
    }

}
