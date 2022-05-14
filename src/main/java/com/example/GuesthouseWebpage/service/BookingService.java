package com.example.GuesthouseWebpage.service;


import com.example.GuesthouseWebpage.model.Booking;
import com.example.GuesthouseWebpage.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    //method to create booking
    public void createBooking(Booking booking){
        booking.setActive(true);
        bookingRepository.save(booking);
    }


    //method to find booking by id
    public Optional<Booking> findBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    //method to update booking by bookingId
    public void updateBooking(Booking booking) {
            bookingRepository.saveAndFlush(booking);
    }

    //method to "delete" booking by booking id - set active false so no one can see the booking
    public void deleteBookingById(Long id) {
            findBookingById(id).ifPresent(booking -> {
                booking.setActive(false);
                    updateBooking(booking);
            });
    }

    //method to restore booking
    public void restoreBookingById(Long id){
        findBookingById(id).ifPresent(booking -> {
            booking.setActive(true);
            updateBooking(booking);
        });
    }

    //method to really fully delete booking by booking id
    public void fullDeleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }

    //list all bookings
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    //list all active bookings
    public List<Booking> getActiveBookings(){
        return getAllBookings().stream()
                .filter(Booking::isActive)
                .collect(Collectors.toList());
    }
    //list all bookings in one date you receive from user


    //list all bookings for one room


}
