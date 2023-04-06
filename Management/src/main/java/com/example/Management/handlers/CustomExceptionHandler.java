package com.example.Management.handlers;

import com.example.Management.exeptions.studentExeptions.CustomEmailIsAlreadyUsedException;
import com.example.Management.exeptions.studentExeptions.CustomNotValidNameException;
import com.example.Management.exeptions.studentExeptions.CustomNullStudentException;
import com.example.Management.exeptions.userExceptions.EmailIsUsedException;
import com.example.Management.exeptions.userExceptions.NotValidNameException;
import com.example.Management.exeptions.userExceptions.NullUserException;
import com.example.Management.exeptions.userExceptions.UsernameIsUsedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomNotValidNameException.class)
    public ModelAndView handleNotValidNameException(CustomNotValidNameException customNotValidNameException) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("message");
        return modelAndView;
    }
    @ExceptionHandler(CustomNullStudentException.class)
    public ModelAndView handleNullUserAndStudentException(CustomNullStudentException nulUserAndStudentException){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("message");
        return modelAndView;
    }
    @ExceptionHandler(CustomEmailIsAlreadyUsedException.class)
    public ModelAndView handleEmailIsAlreadyUsedException(CustomEmailIsAlreadyUsedException emailIsAlreadyUsedException){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin/students/new?error");
        return modelAndView;
    }
    @ExceptionHandler(EmailIsUsedException.class)
    public ModelAndView handleEmailIsUsedException(EmailIsUsedException emailIsUsedException){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/registration?errorEmail");
        return modelAndView;
    }

    @ExceptionHandler(UsernameIsUsedException.class)
    public ModelAndView handleUsernameIsUsedException(UsernameIsUsedException usernameIsUsedException){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/registration?errorUsername");
        return modelAndView;
    }
    @ExceptionHandler(NullUserException.class)
    public ModelAndView handleNullUserException(NullUserException nullUserException){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userMessage");
        return modelAndView;
    }
    @ExceptionHandler(NotValidNameException.class)
    public ModelAndView handleNotValidNameException(NotValidNameException notValidNameException){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userMessage");
        return modelAndView;
    }
}
