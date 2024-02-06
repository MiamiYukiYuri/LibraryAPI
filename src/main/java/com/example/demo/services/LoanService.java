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
    // Retrieves the book which will be borrowed with bookId from bookRepository. If the book is not available the method returns null since I didn't know how to get a displyed message "book not available".
    // If the book is available it puts the books' status to available = false, i.e. not available to borrow, and saves the new status
    // Uses setters to set date for 'borrowed' and 'returnDate', ends with saving the new loan to the database
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



    /*
    // map() = lambda = en funktion/metod. Tar emot ett värde och skickar tillbaka ett värde of my choice
    // inparametern til map-metoden är ett functional interface (= en metod att agera på).
    public Optional<Loan> createLoan(Loan loan) {
        String bookId = loan.getBookId();
        Optional <Loan> returningLoan = bookRepository.findById(bookId).map(
                exsitingBook -> {
            if (exsitingBook.getAvailable()) {
                exsitingBook.setAvailable(false);
                bookRepository.save(exsitingBook);
                loan.setBorrowed(LocalDate.now());
                loan.setReturnDate(LocalDate.now().plusDays(14));
                return loanRepository.save(loan);
            }
            else {
                return null;
            }
        });





        if (book.getAvailable() == true) {
            book.setAvailable(false);
            bookRepository.save(book);
            loan.setBorrowed(LocalDate.now());
            loan.setReturnDate(LocalDate.now().plusDays(14));
        } return loanRepository.save(loan);
        .orElseThrow(() -> new EntityNotFoundException("This book is not available for lending at the moment".));
    }
*/


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