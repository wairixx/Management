package com.example.Management.services;

import com.example.Management.entities.User;

public interface UserValidatorService {
    void executeUser(User user);
    void executeLoginUser(User user);
}
