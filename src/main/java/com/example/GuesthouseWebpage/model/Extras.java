package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Extras {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long extraId;
    private String name;
    private String description;
    private double price;

    //foreign keys
    //vt menuMeal classi kuidas teha
    @ManyToOne
    private GuestHouse guestHouse;

}
