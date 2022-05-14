package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;

//creating table
@Data
@Entity
public class PaymentMethod {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentMethodId;
    private String type;

}
