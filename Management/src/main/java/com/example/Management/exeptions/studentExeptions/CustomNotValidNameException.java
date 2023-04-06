package com.example.Management.exeptions.studentExeptions;

public class CustomNotValidNameException extends RuntimeException {
    public CustomNotValidNameException(String message) {
        super(message);
    }
}
