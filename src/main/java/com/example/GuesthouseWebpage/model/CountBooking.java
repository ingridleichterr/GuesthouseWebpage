package com.example.GuesthouseWebpage.model;


public class CountBooking {

    private long count;
    private String arrivalDate;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public CountBooking(String arrivalDate, long count) {
        this.arrivalDate = arrivalDate;
        this.count = count;

    }

    @Override
    public String toString() {
        return "CountBooking{" +
                "count=" + count +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
