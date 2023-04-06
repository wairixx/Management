package com.example.Management.validators.userValidators;

import com.example.Management.entities.User;
import com.example.Management.services.UserService;
import com.example.Management.exeptions.userExceptions.EmailIsUsedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ValidateEmail implements UserValidator{
    @Autowired
    private UserService userService;

    @Override
    public void execute(User user) {
        if (userService.emailIsUsed(user)){
            throw new EmailIsUsedException("email is used");
        }
    }
}
