package com.example.Management.validators.studentValidators;

import com.example.Management.entities.Student;
import com.example.Management.exeptions.studentExeptions.CustomNullStudentException;
import com.example.Management.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateNullStudent implements StudentValidator {

    @Autowired
    private StudentService studentService;

    @Override
    public void execute(Student student) {
        if (studentService.isNull(student)){
            throw new CustomNullStudentException("null");
        }
    }
}
