package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;

//create table
@Data
@Entity
public class Room {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;
    private String name;
    //foreign key
    @OneToOne
    private RoomType roomType;

    private double price;
    private int availability;
    //foreign key
    @ManyToOne
    private GuestHouse guestHouse;

}
