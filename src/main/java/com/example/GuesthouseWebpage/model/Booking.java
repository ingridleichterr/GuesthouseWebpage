package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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
    private boolean bookingConfirmed;
    private boolean isActive;

    //foreign keys
    @ManyToOne
    private Room room;

    @ManyToOne
    private Meal meal;

    @ManyToOne
    private Extras extras;

    @ManyToOne
    private User user;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;
}
