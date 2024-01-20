package com.example.demo.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

    @Document(collection = "loans")

    public class Loan {
        @Id
        private String id;

        private String bookId; // ??

        private String userId; // ??

        @CreatedDate
        private Date borrowed;
        private Date returnDate;

        // CONSTRUCTOR
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

        public Date getBorrowed() {
            return borrowed;
        }

        public Date getReturnDate() {
            return returnDate;
        }
    }
