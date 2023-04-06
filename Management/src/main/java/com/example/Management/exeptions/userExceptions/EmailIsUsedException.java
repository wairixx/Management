package com.example.Management.exeptions.userExceptions;

public class EmailIsUsedException extends RuntimeException{
    public EmailIsUsedException(String message) {
        super(message);
    }
}
