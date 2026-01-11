package com.sisimpur.library.controller;

import com.sisimpur.library.model.User;
import com.sisimpur.library.service.LendingService;
import com.sisimpur.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final LendingService lendingService;

    // Create or update user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(null, user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.saveOrUpdateUser(id, user);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/{bookId}/assign/{userId}")
    public void assignBook(@PathVariable Long bookId, @PathVariable Long userId) {
        lendingService.assignBookToUser(userId, bookId);
    }

    @PostMapping("/{bookId}/unassign/{userId}")
    public void unassignBook(@PathVariable Long bookId, @PathVariable Long userId) {
        lendingService.unassignBookFromUser(userId, bookId);
    }
}
