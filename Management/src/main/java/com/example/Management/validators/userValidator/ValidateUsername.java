package com.example.Management.validators.userValidator;

import com.example.Management.entities.User;
import com.example.Management.services.UserService;
import com.example.Management.exeptions.userExceptions.UsernameIsUsedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateUsername implements UserValidator{
    @Autowired
    private UserService userService;

    @Override
    public void execute(User user) {
        if (userService.usernameIsUsed(user)){
            throw new UsernameIsUsedException("username is used");
        }
    }
}
