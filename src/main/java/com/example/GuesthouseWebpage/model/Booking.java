package com.example.GuesthouseWebpage.model;

import javax.persistence.*;

//creating table
@Entity
public class Booking {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private int bookingId;

    @Column(name = "arrivalDate")
    private String arrivalDate;

    @Column(name = "leavingDate")
    private String leavingDate;

    @Column(name = "numberOfPeople")
    private int numberOfPeople;

    @Column(name = "bookerName")
    private String bookerName;

    @Column(name = "bookerEmail")
    private String bookerEmail;

    @Column(name = "bookerPhoneNumber")
    private String bookerPhoneNumber;

    //foreign keys
    @OneToOne
    @JoinColumn(name="bookingPaymentId")
    private BookingPayment bookingPaymentId;

    @ManyToOne
    @JoinColumn(name="roomId")
    private Room room;

    @ManyToOne
    @JoinColumn(name="mealId")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name="extraId")
    private Extras extras;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;



    //empty constructor
    public Booking() {
    }

    public Booking(int bookingId, String bookerName, Room room, Meal meal) {
        this.bookingId = bookingId;
        this.bookerName = bookerName;
        this.room = room;
        this.meal = meal;
    }

    //getters and setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(String leavingDate) {
        this.leavingDate = leavingDate;
    }

    public String getBookerName() {
        return bookerName;
    }

    public void setBookerName(String bookerName) {
        this.bookerName = bookerName;
    }

    public String getBookerEmail() {
        return bookerEmail;
    }

    public void setBookerEmail(String bookerEmail) {
        this.bookerEmail = bookerEmail;
    }

    public String getBookerPhoneNumber() {
        return bookerPhoneNumber;
    }

    public void setBookerPhoneNumber(String bookerPhoneNumber) {
        this.bookerPhoneNumber = bookerPhoneNumber;
    }

    public BookingPayment getBookingPaymentId() {
        return bookingPaymentId;
    }

    public void setBookingPaymentId(BookingPayment bookingPaymentId) {
        this.bookingPaymentId = bookingPaymentId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Extras getExtras() {
        return extras;
    }

    public void setExtras(Extras extras) {
        this.extras = extras;
    }

    //to string method

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", leavingDate='" + leavingDate + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", bookerName='" + bookerName + '\'' +
                ", bookerEmail='" + bookerEmail + '\'' +
                ", bookerPhoneNumber='" + bookerPhoneNumber + '\'' +
                ", bookingPaymentId=" + bookingPaymentId +
                ", room=" + room +
                ", meal=" + meal +
                ", extras=" + extras +
                ", user=" + user +
                '}';
    }
}
