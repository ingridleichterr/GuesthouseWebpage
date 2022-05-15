package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private BigDecimal price;
    private boolean isActive;

    //foreign keys
    @Enumerated(EnumType.STRING)
    private MealTypeEnum mealTypeEnum;

    @ManyToOne
    private GuestHouse guestHouse;

}
