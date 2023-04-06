package com.example.Management.exeptions.userExceptions;

public class UsernameIsUsedException extends RuntimeException{
    public UsernameIsUsedException(String message) {
        super(message);
    }
}
