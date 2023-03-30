package com.example.Management.service;

import com.example.Management.entity.User;
import com.example.Management.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public Boolean isLogged(User user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());
        try {
            if (userFromDB.getUsername().equals(user.getUsername())
                    && userFromDB.getPassword().equals(user.getPassword())) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public Boolean usernameIsUsed(User user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if (userFromDB != null && (userFromDB.getUsername().equals(user.getUsername()))){
            return true;
        }
        return false;
    }

    @Override
    public Boolean emailIsUsed(User user) {
        User userFromDB = userRepo.findByEmail(user.getEmail());
        if (userFromDB != null && (userFromDB.getEmail().equals(user.getEmail()))){
            return true;
        }
        return false;
    }

}
