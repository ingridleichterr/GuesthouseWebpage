package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.Booking;
import com.example.GuesthouseWebpage.model.CountBooking;
import com.example.GuesthouseWebpage.model.ShowBookingsOfARoom;
import com.example.GuesthouseWebpage.model.ShowBookingsOnADate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<CountBooking> countAllBookings ();
    List<ShowBookingsOnADate> countAllBookingsByDate();
    List<ShowBookingsOfARoom> countAllBookingsByRoom();
}
