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

    // POST - ADD loan  http://localhost:8080/api/book
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
    // {id} = path parameter
    @GetMapping("/loan/{loanId}")
    public Loan getLoanById(@PathVariable String loanId) {
        return loanService.getLoanById(loanId);
    }


    // GET loan by user id
    // Hämtar listan med lån för specifikt user id
    @GetMapping("/loan/user/{userId}")
    public List<Loan> getLoanByUserId(@PathVariable String userId) {
        return loanService.getLoanByUserId(userId);
    }


    // GET loan by book bookId
    @GetMapping("loan/book/{bookId}")
    public Loan getLoanByBookId(@PathVariable String bookId) {
        return loanService.getLoanByBookId(bookId);
    }

    // PUT - update loan info
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