package com.example.demo.services;

import com.example.demo.exception.EntityNotFoundException;
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
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;


    // ADD - register a new loan
    // Retrieves the book which will be borrowed with bookId from bookRepository
    // If/else depending on the books' status;
    // if the book is not available(=false), i.e. already lent out, the method throws custom exception and displays a message to user, and ends method
    // if the book is available(=true) it then sets the books' status to available = false, i.e. no longer available to borrow, and saves the new status
    // Uses setters to set date for 'borrowed' and 'returnDate', where 'returnDate' has an addition of 14 days from the current date
    // Ends with saving the loan to database
        public Loan createLoan(Loan loan) {
        String bookId = loan.getBookId();
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            Book foundBook = book.get();
            if (!foundBook.getAvailable()) {
                throw new EntityNotFoundException("This book is not available for lending right now.");
            } else {
                foundBook.setAvailable(false);
                bookRepository.save(foundBook);
            }
        }
        loan.setBorrowed(LocalDate.now());
        loan.setReturnDate(LocalDate.now().plusDays(14));
        return loanRepository.save(loan);
    }

    // Add loan to user
    public Loan saveLoan (Loan loan) {
        return loanRepository.save(loan);
    }



    // GET ALL loans
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // GET loan by id
    // pilen -> = lambda
    public Loan getLoanById(String id) {
        return loanRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("This loan id could not be found."));
    }

    // PUT - update loan information, ex. return date
    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    // DELETE - end a loan
    // Finds the loan by loanId and thereafter the book that is attached to the loanId, with bookId
    // Sets the status of the book to available = true, i.e. available for lending
    // Saves the new status and then deletes the loan by loanId
    public String deleteLoan(String id) {
        Loan loan = loanRepository.findById(id).get();
        String bookId = loan.getBookId();
        Book book = bookRepository.findById(bookId).get();
        book.setAvailable(true);
        bookRepository.save(book);
        loanRepository.deleteById(id);
        return "Loan deleted";
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
}