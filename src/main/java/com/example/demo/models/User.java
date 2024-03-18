package com.example.demo.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "users")

public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @CreatedDate
    private Date created;


    // Objekt id-referens
    @DBRef
    private List<Loan> loans = new ArrayList<>();

    // Empty constructor
    public User() {
    }

    // metod för att lägga till ett lån
    public void addLoanToUser(Loan loan) {
        this.loans.add(loan);
    }

    // metod för att ta bort ett lån
    public void deleteLoanFromUser(Loan loan) {
        this.loans.remove(loan);
    }



    // Getter and setter for loan list
    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    // Setters for firstName and lastName

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // GETTERS
    public String getId() {
        return id;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getCreated() { return created; }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", created=" + created +
                '}';
    }
}