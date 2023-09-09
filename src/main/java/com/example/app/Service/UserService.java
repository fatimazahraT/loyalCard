package com.example.app.Service;

import com.example.app.Models.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    User updateUser(Long userId, User updatedUser);
    void deleteUser(Long userId);
    User findByUsername(String username);
}
