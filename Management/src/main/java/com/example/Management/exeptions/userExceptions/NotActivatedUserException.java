package com.example.Management.exeptions.userExceptions;

public class NotActivatedUserException extends RuntimeException{
    public NotActivatedUserException(String message) {
        super(message);
    }
}
