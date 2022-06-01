package com.example.GuesthouseWebpage.service;


import com.example.GuesthouseWebpage.exceptions.BookingNotFoundException;
import com.example.GuesthouseWebpage.model.Booking;
import com.example.GuesthouseWebpage.model.Extras;
import com.example.GuesthouseWebpage.model.Meal;
import com.example.GuesthouseWebpage.model.Room;
import com.example.GuesthouseWebpage.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
    public Booking findBookingById(Long id) throws BookingNotFoundException {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);

        if(optionalBooking.isEmpty()) {
            throw new BookingNotFoundException(id);
        } else {
            return optionalBooking.get();
        }
    }

    //method to update booking by bookingId
    public void updateBooking(Booking booking) {
        bookingRepository.saveAndFlush(booking);
    }

    //method to "delete" booking by booking id - set active false so no one can see the booking
    public void deleteBookingById(Long id) throws BookingNotFoundException {
        Booking booking = findBookingById(id);
        booking.setActive(false);
        updateBooking(booking);
    }

    //method to restore booking
    public void restoreBookingById(Long id) throws BookingNotFoundException {
        Booking booking = findBookingById(id);
        booking.setActive(true);
        updateBooking(booking);
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

    //list all confirmed bookings
    public List<Booking> getConfirmedBookings(){
        return getAllBookings().stream()
                .filter(Booking::isConfirmed)
                .collect(Collectors.toList());
    }

    //calculate total amount of booking
    public BigDecimal calculateTotalAmountOfBooking(Booking booking){
        BigDecimal totalBookingAmount = BigDecimal.ZERO;

        for(Room room: booking.getRooms()) {
            totalBookingAmount = totalBookingAmount.add(room.getPrice());
        }
        for (Meal meal : booking.getMeals()){
            totalBookingAmount = totalBookingAmount.add(meal.getPrice());
        }
        for (Extras extras : booking.getExtras()){
            totalBookingAmount = totalBookingAmount.add(extras.getPrice());
        }

        return totalBookingAmount;
    }

    public List<Room> addRoomsToBooking(Room room){
        List<Room>roomList=new ArrayList<>();
        roomList.add(room);
        return roomList;
    }

    //list all bookings in one date you receive from user


    //list all bookings for one room


}
