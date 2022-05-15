package com.example.GuesthouseWebpage.exceptions;

public class ExtraNotFoundException extends Exception{
    public ExtraNotFoundException(Long id){
        super(String.format("Extra(id=%d not found!", id));
    }
}
