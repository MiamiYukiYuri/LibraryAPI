package com.example.demo.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

    @Document(collection = "loans")

    public class Loan {
        @Id
        private String id;
        private String bookId;
        private String userId;
        @CreatedDate
        private LocalDate borrowed;
        private LocalDate returnDate;


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

        public LocalDate getBorrowed() {
            return borrowed;
        }

        public LocalDate getReturnDate() {
            return borrowed.plusDays(14);
        }

        // SETTER - for updating the return date
        public void setReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
        }
    }