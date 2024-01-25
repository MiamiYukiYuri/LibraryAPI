package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    // ADD book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // GET ALL books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // GET book by id
    public Book getBookById(String id) {
        return bookRepository.findById(id).get();
    }

    // PUT - update book info
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    // DELETE book
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}