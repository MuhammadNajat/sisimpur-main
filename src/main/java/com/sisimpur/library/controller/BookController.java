package com.sisimpur.library.controller;

import org.springframework.web.bind.annotation.*;

import com.sisimpur.library.model.Book;
import com.sisimpur.library.service.BookService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // Create a book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveOrUpdateBook(null, book);
    }

    // Fetch a single book by id
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    // Fetch all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Update a book
    @PutMapping("/{id}")
    public Book updateBook(
            @PathVariable Long id,
            @RequestBody Book book
    ) {
        return bookService.saveOrUpdateBook(id, book);
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
