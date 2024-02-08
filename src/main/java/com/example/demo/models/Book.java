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
    private String description;
    private String pageAmount;
    private boolean available = true;
    @CreatedDate
    private Date added;

    // Empty constructor
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


    // SETTER
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", pageAmount='" + pageAmount + '\'' +
                ", available=" + available +
                ", added=" + added +
                '}';
    }
}