package com.sisimpur.library.service;

import com.sisimpur.library.model.Book;
import com.sisimpur.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveOrUpdateBook(Long id, Book book) {
        if (book == null) {
            return null;
        }
        Book toSaveOrUpdate = bookRepository.findById(id).orElse(new Book());
        toSaveOrUpdate.setAssignedTo(book.getAssignedTo());
        toSaveOrUpdate.setTitle(book.getTitle());
        toSaveOrUpdate.setGenre(book.getGenre());
        toSaveOrUpdate.setPublishedYear(book.getPublishedYear());
        toSaveOrUpdate.setAuthors(book.getAuthors());
        return bookRepository.save(toSaveOrUpdate);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
