package com.sisimpur.library.service;

import com.sisimpur.library.model.User;
import com.sisimpur.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // Create or update user
    public User saveOrUpdateUser(Long id, User user) {
        if (user == null) {
            return null;
        }
        User toSaveOrUpdate = userRepository.findById(id).orElse(new User());
        toSaveOrUpdate.setName(user.getName());
        toSaveOrUpdate.setAssignedBooks(user.getAssignedBooks());
        return userRepository.save(toSaveOrUpdate);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Delete a user by ID
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
