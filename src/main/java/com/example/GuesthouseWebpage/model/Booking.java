package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;
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
    private boolean isActive;

    //foreign keys
    @OneToOne
    private BookingPayment bookingPaymentId;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Meal meal;

    @ManyToOne
    private Extras extras;

    @ManyToOne
    private User user;
}
