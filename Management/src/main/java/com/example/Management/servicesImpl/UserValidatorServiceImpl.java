package com.example.Management.servicesImpl;

import com.example.Management.entities.User;
import com.example.Management.services.UserValidatorService;
import com.example.Management.validators.userValidator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserValidatorServiceImpl implements UserValidatorService {
    private final List<UserValidator> validators = new LinkedList<>();

    @Autowired
    private ValidateNotActivatedUserException validateNotActivatedUserException;

    public UserValidatorServiceImpl(ValidateNullUser validateNullUser,
                          ValidateEmail validateEmail,
                          ValidateUsername validateUsername,
                          ValidateNotValidName validateNotValidName){
        validators.add(validateUsername);
        validators.add(validateEmail);
        validators.add(validateNotValidName);
        validators.add(validateNullUser);
    }
    @Override
    public void executeUser(User user) {
        for (UserValidator validator: validators){
            validator.execute(user);
        }
    }

    @Override
    public void executeLoginUser(User user) {
        validateNotActivatedUserException.execute(user);
    }
}
