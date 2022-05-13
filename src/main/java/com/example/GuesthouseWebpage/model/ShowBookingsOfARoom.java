package com.example.GuesthouseWebpage.model;

public class ShowBookingsOfARoom {

    private int roomId;
    private String roomName;
    private String arrivalDate;
    private int bookingId;
    private String customerName;

    public ShowBookingsOfARoom(int roomId, String roomName, String arrivalDate, int bookingId, String customerName) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.arrivalDate = arrivalDate;
        this.bookingId = bookingId;
        this.customerName = customerName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
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

    @Override
    public String toString() {
        return "ShowBookingsOfARoom{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", bookingId=" + bookingId +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}


