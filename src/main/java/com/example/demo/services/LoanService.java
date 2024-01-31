package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.models.Loan;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;

    // ADD - register a new loan
    // Retrieves the book which will be borrowed with bookId from bookRepository. If the book is not available the method returns null
    // If the book is available it puts the books' status to available = false, i.e. not available to borrow, and saves the new status
    // Uses setters to set date for 'borrowed' and 'returnDate', ends with saving the new loan to the database
    public Loan createLoan(Loan loan) {
        String bookId = loan.getBookId();
        Book book = bookRepository.findById(bookId).get();
        if (book.getAvailable() == false) {
            return null;
        } else {
            book.setAvailable(false);
            bookRepository.save(book);
        }
        loan.setBorrowed(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(14));
        return loanRepository.save(loan);
    }

    // GET ALL loans
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // GET loan by id
    public Loan getLoanById(String id) {
        return loanRepository.findById(id).get();
    }

    // GET loan by userId
    // Lists all loans based on a specific userId
    // Loops through the list of loans and adds the loans which matches the userId to a new array list; userLoanList
    // Returns the array list of loans for a single user
    public List<Loan> getLoanByUserId(String id) {
        List<Loan> userLoanList = new ArrayList<>();
        for (Loan loan : loanRepository.findAll()) {
            if (Objects.equals(loan.getUserId(), id)) {
                userLoanList.add(loan);
            }
        }
        return userLoanList;
    }

    // GET loan by bookId
    // Puts the variable 'foundLoan' to null initially
    // Loops through all loans until there is a match with the bookId
    // The variable 'foundLoan' now represent the match and is returned in the end of the method
    public Loan getLoanByBookId(String id) {
        Loan foundLoan = null;
        for (Loan loan : loanRepository.findAll()) {
            if (Objects.equals(loan.getBookId(), id)) {
                foundLoan = loan;
                break;
            }
        }
        return foundLoan;
    }

    // PUT - update loan information, ex. return date
    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    // DELETE - end a loan
    // Finds the loan by loanId and thereafter the book that is attached to the loanId, with bookId
    // Sets the status of the book to available = true, i.e. available for lending
    // Saves the new status and then deletes the loan by loanId
    public void deleteLoan(String id) {
        Loan loan = loanRepository.findById(id).get();
        String bookId = loan.getBookId();
        Book book = bookRepository.findById(bookId).get();
        book.setAvailable(true);
        bookRepository.save(book);
        loanRepository.deleteById(id);
    }
}