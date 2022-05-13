package com.example.GuesthouseWebpage.model;

public class ShowBookingsOnADate {

    private int bookingId;
    private String customerName;
    private String roomName;
    private String mealName;

    public ShowBookingsOnADate(int bookingId, String customerName, String roomName, String mealName) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.roomName = roomName;
        this.mealName = mealName;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String toString() {
        return "ShowBookingsOnADate{" +
                "bookingId=" + bookingId +
                ", customerName='" + customerName + '\'' +
                ", roomName='" + roomName + '\'' +
                ", mealName='" + mealName + '\'' +
                '}';
    }
}
