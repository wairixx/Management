package com.example.Management.handlers;

import com.example.Management.exeptions.CustomNotValidNameExeption;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class NotValidNameExeptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomNotValidNameExeption.class)
    public ModelAndView handleNotValidNameExeption(CustomNotValidNameExeption customNotValidNameExeption){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
