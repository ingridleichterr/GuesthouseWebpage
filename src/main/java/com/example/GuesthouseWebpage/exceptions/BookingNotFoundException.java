package com.example.GuesthouseWebpage.exceptions;

public class BookingNotFoundException extends Exception{
    public BookingNotFoundException(Long id){
        super(String.format("Booking(id=%d not found!", id));
    }
}
