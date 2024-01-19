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

    // POST   http://localhost:8080/api/book
    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    // GET ALL books
    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET book by id
    // {id} = path parameter
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    // PUT update a book
    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    // DELETE a book
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }
}
