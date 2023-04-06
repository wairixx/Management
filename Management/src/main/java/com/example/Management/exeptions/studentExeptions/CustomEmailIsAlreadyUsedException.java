package com.example.Management.exeptions.studentExeptions;

public class CustomEmailIsAlreadyUsedException extends RuntimeException{
    public CustomEmailIsAlreadyUsedException(String message) {
        super(message);
    }
}
