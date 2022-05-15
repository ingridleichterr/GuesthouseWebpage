package com.example.GuesthouseWebpage.exceptions;

public class RoomNotFoundException extends Exception{
    public RoomNotFoundException(Long id){
        super(String.format("Room(id=%d not found!", id));
    }
}
