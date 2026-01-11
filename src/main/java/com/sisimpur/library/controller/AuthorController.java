package com.sisimpur.library.controller;

import com.sisimpur.library.model.Author;
import com.sisimpur.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    // Create new author
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.saveOrUpdateAuthor(null, author);
    }

    // Update existing author
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        return authorService.saveOrUpdateAuthor(id, author);
    }

    // Get all authors
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // Get author by ID
    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }

    // Delete author by ID
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
    }
}
