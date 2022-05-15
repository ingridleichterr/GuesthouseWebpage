package com.example.GuesthouseWebpage.exceptions;

public class MealNotFoundException extends Exception{
    public MealNotFoundException(Long id){
        super(String.format("Meal(id=%d not found!", id));
    }
}
