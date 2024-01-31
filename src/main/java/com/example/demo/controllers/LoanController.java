package com.example.demo.controllers;

import com.example.demo.services.LoanService;
import com.example.demo.models.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class LoanController {

    @Autowired
    LoanService loanService;

    // POST - create a new loan  http://localhost:8080/api/book
    @PostMapping("/loan")
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
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
    public void deleteLoan(@PathVariable String loanId) {
        loanService.deleteLoan(loanId);
    }
}