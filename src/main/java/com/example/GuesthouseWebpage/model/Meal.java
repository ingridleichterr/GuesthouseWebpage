package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;

//create table
@Data
@Entity
public class Meal {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mealId;
    private String name;
    private String description;
    private double price;
    private boolean isActive;

    //foreign keys
    @ManyToOne
    private MealType mealType;

    @ManyToOne
    private GuestHouse guestHouse;

}
