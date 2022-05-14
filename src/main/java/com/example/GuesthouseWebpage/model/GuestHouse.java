package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;

//creating table
@Data
@Entity
public class GuestHouse {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long guestHouseId;
    private String name;
    private String address;
    private String phoneNumber;

}
