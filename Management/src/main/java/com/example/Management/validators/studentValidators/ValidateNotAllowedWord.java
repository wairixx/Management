package com.example.Management.validators.studentValidators;

import com.example.Management.entities.Student;
import com.example.Management.exeptions.studentExeptions.CustomNotValidNameException;
import org.springframework.stereotype.Component;

@Component
public class ValidateNotAllowedWord implements StudentValidator {

    @Override
    public void execute(Student student) {
        if (student.getFirstName().equals("test")
                || student.getLastName().equals("test")
                || student.getEmail().equals("test")){
            throw new CustomNotValidNameException("forbidden word");
        }
    }

}
