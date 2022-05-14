package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Booking;
import com.example.GuesthouseWebpage.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    //method to create booking
    public void createBooking(Booking booking){
        bookingRepository.save(booking);
    }

    //method to update booking by bookingId
    public void updateBookingByBookingId(Booking booking, long bookingId){
        List<Booking>bookings = new ArrayList<>();
        for (int i=0; i<bookings.size(); i++){
            Booking b = bookings.get(i);
            if(b.getId().equals(bookingId)){
                bookings.set(i, booking);
            }
        }
    }

    //method to delete booking by booking id

    //method count all bookings by date
   /*
   public List<Booking> bookingsByDate(){
        return bookingRepository.findAll().stream()
                .sorted();
    }

    */

    //list all bookings in one date you receive from user

    //list all bookings for one room


}
