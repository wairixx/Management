package com.example.Management.services;

import com.example.Management.entities.User;

public interface UserService {
    User findByUsername(String username);
    User findByEmail(String email);
    void save(User user);

    Boolean isLogged(User user);

    Boolean usernameIsUsed(User user);

    Boolean emailIsUsed(User user);

    Boolean isNull(User user);
}
