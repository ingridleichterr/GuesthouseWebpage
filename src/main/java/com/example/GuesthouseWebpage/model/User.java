package com.example.GuesthouseWebpage.model;

import lombok.Data;

import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

//creating table
@Data
@Entity
public class User {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@NotBlank(message="Email can not be empty!")
    //as username
    private String email;

    private String password;

    //@NotBlank(message="Name can not be empty!")
    private String name;

    //@NotBlank(message="Phone number can not be empty!")
    private String phoneNumber;

    private LocalDate registrationDate;

    private boolean isActive;

    @OneToOne(cascade = CascadeType.MERGE)
    private Authority authority;

}
