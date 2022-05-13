package com.example.GuesthouseWebpage.model;

import javax.persistence.*;

//create table
@Entity
public class Room {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private int roomId;

    @Column(name = "name")
    private String name;

    //foreign key
    @OneToOne
    @JoinColumn(name="roomTypeId")
    private RoomType roomType;


    @Column(name = "price")
    private double price;

    @Column(name = "availability")
    private int availability;

    //foreign key
    @ManyToOne
    @JoinColumn(name="guestHouseId")
    private GuestHouse guestHouse;


    //constructor
    public Room(String name, int availability, double price, RoomType roomType) {
        this.name = name;
        this.availability = availability;
        this.price = price;
        this.roomType = roomType;
    }
    //empty constructor
    public Room() {
    }

    //getters and setters

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
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

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    //to string method

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", availability=" + availability +
                ", price=" + price +
                ", guestHouse=" + guestHouse +
                ", roomType=" + roomType +
                '}';
    }
}
