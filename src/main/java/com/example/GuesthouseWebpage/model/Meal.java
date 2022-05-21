package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

//create table
@Data
@Entity
public class Meal {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean isActive;

    //foreign keys
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @ManyToOne
    private GuestHouse guestHouse;

    @OneToMany
    private List<MealImage> mealImages;


}
