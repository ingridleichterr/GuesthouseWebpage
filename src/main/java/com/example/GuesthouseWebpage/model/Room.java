package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

//create table
@Data
@Entity
public class Room {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private BigDecimal price;

    //foreign key
    @OneToOne
    private GuestHouse guestHouse;

    private boolean isActive;

    @OneToMany
    private List<RoomImage> roomImages;

}
