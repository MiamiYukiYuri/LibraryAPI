package com.example.demo.services;

import com.example.demo.models.Loan;
import com.example.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanService {

        @Autowired
        LoanRepository loanRepository;

        // ADD - register a new loan
        public Loan createLoan(Loan loan) {
            return loanRepository.save(loan);
        }

        // GET ALL loaned books
        public List<Loan> getAllLoans() {
            return loanRepository.findAll();
        }

        // GET a specific loan by id
        public Loan getLoanById(String id) {
            return loanRepository.findById(id).get();
        }

        // PUT - update loan info, ex. return date
        public Loan updateLoan(Loan loan) {
            return loanRepository.save(loan);
        }

        // DELETE - end a loan
        public void deleteLoan(String id) {
            loanRepository.deleteById(id);
        }

    }