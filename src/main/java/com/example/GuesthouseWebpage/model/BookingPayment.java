package com.example.GuesthouseWebpage.model;

import javax.persistence.*;

//creating table
@Entity
public class BookingPayment {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingPaymentId")
    private int bookingPaymentId;

    @Column(name = "totalAmount")
    private int totalPrice;

    //foreign keys
    @ManyToOne
    @JoinColumn(name="paymentMethodId")
    private PaymentMethod paymentMethod;

    //getters and setters
    public int getBookingPaymentId() {return bookingPaymentId;
    }

    public void setBookingPaymentId(int bookingPaymentId) {this.bookingPaymentId = bookingPaymentId;
    }

    public int getTotalPrice() {return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {this.totalPrice = totalPrice;
    }

    //to string method
    @Override
    public String toString() {
        return "bookingPayment{" +
                "bookingPaymentId=" + bookingPaymentId +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
