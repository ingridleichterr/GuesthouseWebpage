package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;

//creating table
@Data
@Entity
public class BookingPayment {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingPaymentId;
    private int totalPrice;

    //foreign keys
    @ManyToOne
    private PaymentMethod paymentMethod;

}
