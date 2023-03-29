package com.example.Management.exeptions;

public class CustomNotValidNameExeption extends RuntimeException{

    public CustomNotValidNameExeption(String message) {
        super(message);
    }
}
