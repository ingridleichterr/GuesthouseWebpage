package com.example.GuesthouseWebpage.model;

import javax.persistence.*;

@Entity
public class Extras {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "extraId")
    private int extraId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    //foreign keys
    //vt menuMeal classi kuidas teha
    @ManyToOne
    @JoinColumn(name="guestHouseId")
    private GuestHouse guestHouse;

    //Getters and setters
    public int getExtraId() {
        return extraId;
    }

    public void setExtraId(int extraId) {
        this.extraId = extraId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GuestHouse getGuestHouse() {
        return guestHouse;
    }

    public void setGuestHouse(GuestHouse guestHouse) {
        this.guestHouse = guestHouse;
    }

    //to string method
    @Override
    public String toString() {
        return "Extras{" +
                "extraId=" + extraId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", guestHouse=" + guestHouse +
                '}';
    }
}
