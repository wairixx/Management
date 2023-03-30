package com.example.Management.service;

import com.example.Management.entity.User;

public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
    void save(User user);

    Boolean isLogged(User user);

    Boolean usernameIsUsed(User user);

    Boolean emailIsUsed(User user);
}
