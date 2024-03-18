/*
package com.example.demo.controllers;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.services.LoanService;
import com.example.demo.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class LoanController {

    @Autowired
    LoanService loanService;

    // POST - create a new loan  http://localhost:8080/api/loan
    // Trying out Response Entity
    @PostMapping("/loan")
    public ResponseEntity<?> createLoan(@RequestBody Loan loan) {
        try {
            Loan createdLoan = loanService.createLoan(loan);
            return ResponseEntity.ok(createdLoan);
        } catch (EntityNotFoundException entityNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entityNotFoundException.getMessage());
        }
    }

    // GET ALL loans
    @GetMapping("/loan")
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    // GET loan by id
    @GetMapping("/loan/{loanId}")
    public Loan getLoanById(@PathVariable String loanId) {
        return loanService.getLoanById(loanId); }

    // PUT - update loan information
    @PutMapping("/loan")
    public Loan updateLoan(@RequestBody Loan loan) {
        return loanService.updateLoan(loan);
    }

    // DELETE loan
    @DeleteMapping("/loan/{loanId}")
    public String deleteLoan(@PathVariable String loanId) {
        return loanService.deleteLoan(loanId);
    }
}

 */