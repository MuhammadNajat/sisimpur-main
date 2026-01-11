package com.sisimpur.library.service;

import com.sisimpur.library.model.Book;
import com.sisimpur.library.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LendingService {
    private final UserService userService;
    private final BookService bookService;

    public void assignBookToUser(Long userId, Long bookId) {
        User user = userService.getUser(userId);
        Book book = bookService.getBook(bookId);

        if (book.getAssignedTo() != null) {
            throw new RuntimeException("Book is already assigned to another user");
        }

        book.setAssignedTo(user);
        user.getAssignedBooks().add(book);

        bookService.saveOrUpdateBook(bookId, book);
        userService.saveOrUpdateUser(userId, user);
    }

    public void unassignBookFromUser(Long userId, Long bookId) {
        User user = userService.getUser(userId);
        Book book = bookService.getBook(bookId);

        if (!user.getAssignedBooks().contains(book)) {
            throw new RuntimeException("This user does not have this book");
        }

        book.setAssignedTo(null);
        user.getAssignedBooks().remove(book);

        bookService.saveOrUpdateBook(bookId, book);
        userService.saveOrUpdateUser(userId, user);
    }

}
