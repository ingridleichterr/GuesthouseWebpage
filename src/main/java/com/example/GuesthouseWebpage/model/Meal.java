package com.example.GuesthouseWebpage.model;

import javax.persistence.*;

//create table
@Entity
public class Meal {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealId")
    private int mealId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    //foreign keys
    //vt menuMeal classi kuidas teha
    @ManyToOne
    @JoinColumn(name="mealTypeId")
    private MealType mealType;

    @ManyToOne
    @JoinColumn(name="guestHouseId")
    private GuestHouse guestHouse;


    //getters and setters
    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
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

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
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
        return "Meal{" +
                "mealId=" + mealId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", mealType=" + mealType +
                ", guestHouse=" + guestHouse +
                '}';
    }
}
