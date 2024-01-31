package com.example.demo.controllers;

import com.example.demo.services.BookService;
import com.example.demo.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class BookController {

    @Autowired
    BookService bookService;

    // POST - add a new book to the library  http://localhost:8080/api/book
    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    // GET ALL books
    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET book by bookId
    @GetMapping("/book/{bookId}")
    public Book getBookById(@PathVariable String bookId) {
        return bookService.getBookById(bookId);
    }

    // PUT - update book information
    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    // DELETE book
    @DeleteMapping("/book/{bookId}")
    public void deleteBook(@PathVariable String bookId) {
        bookService.deleteBook(bookId);
    }
}