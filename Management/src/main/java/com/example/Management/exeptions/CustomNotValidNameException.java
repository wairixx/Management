package com.example.Management.exeptions;

public class CustomNotValidNameException extends RuntimeException {
    public CustomNotValidNameException(String message) {
        super(message);
    }
}
