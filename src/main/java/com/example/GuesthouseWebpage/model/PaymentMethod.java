package com.example.GuesthouseWebpage.model;

import javax.persistence.*;

//creating table
@Entity
public class PaymentMethod {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentMethodId")
    private int paymentMethodId;

    @Column(name = "type")
    private String type;


    //getters and setters
    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //to string method
    @Override
    public String toString() {
        return "paymentMethod{" +
                "paymentMethodId=" + paymentMethodId +
                ", type='" + type + '\'' +
                '}';
    }
}
