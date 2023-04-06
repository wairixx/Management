package com.example.Management.servicesImpl;

import com.example.Management.entities.Student;
import com.example.Management.services.StudentValidatorService;
import com.example.Management.validators.studentValidators.StudentValidator;
import com.example.Management.validators.studentValidators.ValidateEmailIsAlreadyUsed;
import com.example.Management.validators.studentValidators.ValidateNotAllowedWord;
import com.example.Management.validators.studentValidators.ValidateNullStudent;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class StudentValidatorServiceImpl implements StudentValidatorService {
    private final List<StudentValidator> validators = new LinkedList<>();

    public  StudentValidatorServiceImpl(ValidateEmailIsAlreadyUsed emailIsAlreadyUsedValidator,
                             ValidateNotAllowedWord notAllowedWordValidator,
                             ValidateNullStudent nullStudentValidator) {
        validators.add(emailIsAlreadyUsedValidator);
        validators.add(nullStudentValidator);
        validators.add(notAllowedWordValidator);
    }

    @Override
    public void executeStudent(Student student) {
        for (StudentValidator validator: validators){
            validator.execute(student);
        }
    }
}
