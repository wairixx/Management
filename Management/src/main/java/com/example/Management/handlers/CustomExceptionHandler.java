package com.example.Management.handlers;

import com.example.Management.exeptions.CustomNotValidNameException;
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
}
