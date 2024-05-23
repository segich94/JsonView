package com.example.json_view.service;

import com.example.json_view.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    void deleteUser(Long id);
    User updateUser(Long id, User user);
    User getUser(Long id);
    List<User> getAllUser();
}
