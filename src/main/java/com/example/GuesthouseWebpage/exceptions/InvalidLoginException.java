package com.example.GuesthouseWebpage.exceptions;


public class InvalidLoginException extends Exception {
    public InvalidLoginException(String email) {
        super("Invalid login credentials for email: " + email);
    }
}
