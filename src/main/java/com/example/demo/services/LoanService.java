package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.models.Loan;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    // Skapa ett lån där vi först hämtar bookId från loan som vi sedan använder för att hämta rätt bok från bookRepository
    // När vi hämtat boken uppdaterar vi status på specifik bok till ej tillgänglig för utlånging
    // Vi sparar ner bokens nya tillstånd (ej tillgänglig) till databasen
    // Därefter skapas lånet
    public Loan createLoan(Loan loan) {
        String bookId = loan.getBookId();
        Book book = bookRepository.findById(bookId).get();
        book.setAvailable(false);
        bookRepository.save(book);
        return loanRepository.save(loan);
    }

    // GET ALL loans
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // GET a specific loan by id
    public Loan getLoanById(String id) {
        return loanRepository.findById(id).get();
    }

    // Skapar en ny arraylist, userLoanList
    // Letar sedan efter alla lån i loanRepository
    // Om lånets userId matchar så lägger vi till det i vår array list
    // Slutligen returnar vi hela vår arraylist med lån för en enskild användare
    public List<Loan> getLoanByUserId(String id) {
        List<Loan> userLoanList = new ArrayList<>();
        for (Loan loan : loanRepository.findAll()) {
            if (Objects.equals(loan.getUserId(), id)) {
                userLoanList.add(loan);
            }
        }
        return userLoanList;
    }

    // GET loan by book id
    // Loan sätts till null initialt
    // loopar genom alla lån
    // Om bokid matchar så blir det "foundLoan" = loan  som vi sedan returnerar i slutet på metoden
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

    // PUT - update loan info, ex. return date
    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    // DELETE - end a loan
    // Hämtar loanId för att kunna hämta bookId och ändra status till available = true
    // Sparar bokens nya status och tar sedan bort lånet
    public void deleteLoan(String id) {
        Loan loan = loanRepository.findById(id).get();
        String bookId = loan.getBookId();
        Book book = bookRepository.findById(bookId).get();
        book.setAvailable(true);
        bookRepository.save(book);
        loanRepository.deleteById(id);
    }
}