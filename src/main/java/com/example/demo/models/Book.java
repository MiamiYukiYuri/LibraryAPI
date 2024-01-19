package com.example.demo.models;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "books")

public class Book {
    @Id
    private String id;

    private String title;

    private String author;

    private String pageAmount;

    @CreatedDate
    private Date added;

    private Date borrowed;
    private Date returned;


    // Tom konstruktor för att inte Postman ska balla ur
    public Book() {
    }


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

    public Date getBorrowed() {
        return borrowed;
    }

    public Date getReturned() {
        return returned;
    }

    public Date getAdded() {
        return added;
    }
}
