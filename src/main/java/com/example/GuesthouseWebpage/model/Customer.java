package com.example.GuesthouseWebpage.model;

import javax.persistence.*;
import java.time.LocalDate;

//creating table
@Entity
public class Customer {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private int customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dateOfRegister")
    private LocalDate dateOfRegister = LocalDate.now();

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfRegister() {
        return dateOfRegister;
    }

    public void setDateOfRegister(LocalDate dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

//to string method

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", dateOfRegister=" + dateOfRegister +
                '}';
    }
}
