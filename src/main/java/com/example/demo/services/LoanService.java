package com.example.demo.services;
import com.example.demo.models.Loan;
import com.example.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    // Add loan to user
    public Loan saveLoan (Loan loan) {
        return loanRepository.save(loan);
    }
}