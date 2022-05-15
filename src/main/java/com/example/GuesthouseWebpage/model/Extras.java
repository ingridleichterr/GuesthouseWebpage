package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Extras {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long extraId;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean isActive;

    //foreign keys
    @ManyToOne
    private GuestHouse guestHouse;

}
