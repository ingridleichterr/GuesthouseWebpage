package com.example.GuesthouseWebpage.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(Long id){
        super(String.format("User(id=%d not found!", id));
    }
}
