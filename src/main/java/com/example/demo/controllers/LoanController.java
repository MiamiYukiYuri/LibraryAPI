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
    @GetMapping("/loan/{id}")
    public Loan getLoanById(@PathVariable String id) {
        return loanService.getLoanById(id);
    }

/*
    // GET loan by user id ???
    @GetMapping("/loan/user/{id}")
    public Loan getLoanByUserId(@PathVariable String id) {
        return loanService.getLoanByUserId(id);
    }


    // GET loan by book id ????
    @GetMapping("loan/user/{id}")
    public Loan getLoanByBookId(@PathVariable String id) {
        return loanService.getLoanByBookId(id);
    }
   */


    // PUT - update loan info
    @PutMapping("/loan/{id}")
    public Loan updateLoan(@RequestBody Loan loan) {
        return loanService.updateLoan(loan);
    }

    // DELETE loan
    @DeleteMapping("/loan/{id}")
    public void deleteLoan(@PathVariable String id) {
        loanService.deleteLoan(id);
    }
}