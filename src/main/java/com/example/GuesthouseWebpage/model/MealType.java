package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;

//creating table
@Data
@Entity
public class MealType {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mealId;
    private String name;
    private String description;
    private boolean isActive;

}
