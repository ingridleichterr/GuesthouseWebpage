package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

//create table
@Data
@Entity
public class Room {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomId;
    private String name;

    @Enumerated(EnumType.STRING)
    private RoomTypeEnum roomTypeEnum;

    private BigDecimal price;
    private int availability;

    //foreign key
    @ManyToOne
    private GuestHouse guestHouse;

    private boolean isActive;

}
