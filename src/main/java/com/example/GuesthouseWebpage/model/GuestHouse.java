package com.example.GuesthouseWebpage.model;

import javax.persistence.*;

//creating table
@Entity
public class GuestHouse {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestHouseId")
    private int guestHouseId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    //constructor
    public GuestHouse(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //empty constructor
    public GuestHouse() {
    }

    //getters and setters
    public int getGuestHouseId() {return guestHouseId;
    }

    public void setGuestHouseId(int bookingId) {this.guestHouseId = bookingId;
    }

    public String getName() {return name;
    }

    public void setName(String name) {this.name = name;
    }

    public String getAddress() {return address;
    }

    public void setAddress(String address) {this.address = address;
    }

    public String getPhoneNumber() {return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;
    }

    //to string method

    @Override
    public String toString() {
        return "GuestHouse{" +
                "bookingId=" + guestHouseId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
