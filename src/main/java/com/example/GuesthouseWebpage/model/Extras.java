package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Extras {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long extraId;
    private String name;
    private String description;
    private double price;
    private boolean isActive;

    //foreign keys
    //vt menuMeal classi kuidas teha
    @ManyToOne
    private GuestHouse guestHouse;

}
