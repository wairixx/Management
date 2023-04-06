package com.example.Management.validators.userValidators;

import com.example.Management.entities.User;
import com.example.Management.exeptions.studentExeptions.CustomNotValidNameException;
import org.springframework.stereotype.Component;

@Component
public class ValidateNotValidName implements UserValidator{
    @Override
    public void execute(User user) {
        if (user.getUsername().equals("test")
                || user.getEmail().equals("test")){
            throw new CustomNotValidNameException("forbidden word");
        }
    }
}
