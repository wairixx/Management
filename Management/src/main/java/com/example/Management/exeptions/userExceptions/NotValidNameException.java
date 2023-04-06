package com.example.Management.exeptions.userExceptions;

public class NotValidNameException extends RuntimeException{
    public NotValidNameException(String message) {
        super(message);
    }
}
