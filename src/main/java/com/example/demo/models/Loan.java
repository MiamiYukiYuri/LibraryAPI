package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "loans")

public class Loan {
    @Id
    private String id;
    private String bookId;
    private String userId;
    private LocalDate borrowed;
    private LocalDate returnDate;

    // Empty constructor
    public Loan() {
    }

    // GETTERS
    public String getId() {
        return id;
    }

    public String getBookId() {
        return bookId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getBorrowed() {
        return borrowed;
    }

    public LocalDate getReturnDate() { return returnDate; }

    // SETTERS
    public void setReturnDate(LocalDate returnDate) {
      this.returnDate = returnDate;
    }

    public void setBorrowed(LocalDate borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", borrowed=" + borrowed +
                ", returnDate=" + returnDate +
                '}';
    }
}