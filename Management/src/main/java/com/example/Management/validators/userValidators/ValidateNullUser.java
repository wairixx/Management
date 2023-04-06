package com.example.Management.validators.userValidators;

import com.example.Management.entities.User;
import com.example.Management.services.UserService;
import com.example.Management.exeptions.userExceptions.NullUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateNullUser implements UserValidator{
    @Autowired
    private UserService userService;
    @Override
    public void execute(User user) {
        if (userService.isNull(user)){
            throw new NullUserException("null word");
        }
    }
}
