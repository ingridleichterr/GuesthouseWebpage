package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//creating table
@Data
@Entity
public class Booking {
    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate arrivalDate;
    private LocalDate leavingDate;
    private int numberOfPeople;
    private String name;
    private String email;
    private String phoneNumber;

    //foreign keys
    @OneToMany
    private List<Room> rooms;

    @OneToMany
    private List<Meal> meals;

    @OneToMany
    private List<Extras> extras;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String comments;

    @OneToOne
    private User user;

    private boolean isConfirmed;
    private boolean isActive;
    private boolean isPaid;

}
