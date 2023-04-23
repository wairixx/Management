package com.example.Management.validators.userValidator;

import com.example.Management.entities.User;
import com.example.Management.exeptions.userExceptions.NotActivatedUserException;
import org.springframework.stereotype.Component;

@Component
public class ValidateNotActivatedUserException implements UserValidator{
    @Override
    public void execute(User user) {
        if (!user.getActivated()){
            throw new NotActivatedUserException("not activated account");
        }
    }
}
