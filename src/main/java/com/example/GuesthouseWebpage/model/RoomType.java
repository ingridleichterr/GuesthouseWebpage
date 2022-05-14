package com.example.GuesthouseWebpage.model;


import lombok.Data;

import javax.persistence.*;

//creating table
@Data
@Entity
public class RoomType {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomTypeId;
    private String name;
    private String description;
    private String priceRange;
    private int quantity;
    private boolean isActive;

}
