package com.sisimpur.library.service;

import com.sisimpur.library.model.Author;
import com.sisimpur.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    // Create or update author
    public Author saveOrUpdateAuthor(Long id, Author author) {
        if (author == null) {
            return null;
        }

        Author toSaveOrUpdate = authorRepository.findById(id).orElse(new Author());

        toSaveOrUpdate.setName(author.getName());
        toSaveOrUpdate.setBooks(author.getBooks()); // optional, books can be linked

        return authorRepository.save(toSaveOrUpdate);
    }

    // Get all authors
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Get author by ID
    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    // Delete author by ID
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }
}
