package com.example.GuesthouseWebpage.controller;



import com.example.GuesthouseWebpage.exceptions.BookingNotFoundException;
import com.example.GuesthouseWebpage.model.Booking;
import com.example.GuesthouseWebpage.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//controller to handle booking requests
@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = {"http://localhost:4200"})
public class BookingController {

    //field injection
    @Autowired
    private BookingService bookingService;

    //create method
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking){
        bookingService.createBooking(booking);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //update method
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Booking>updateBooking(@RequestBody Booking booking) throws BookingNotFoundException {
        bookingService.updateBooking(booking);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());

        return new ResponseEntity<>(booking, headers, HttpStatus.OK);
    }

    //delete/hide/setActiveFalse method
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBookingById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete method
    @GetMapping("/full-delete/{id}")
    public ResponseEntity<?> fullDeleteBooking(@PathVariable Long id) throws BookingNotFoundException {
        bookingService.fullDeleteBookingById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //restore/unhide/setAvticeTrue method
    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreBooking(@PathVariable Long id) {
        bookingService.restoreBookingById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //list all method
    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    //list all active method
    @GetMapping("/active")
    public List<Booking> getAllActiveBookings(){
        return bookingService.getActiveBookings();
    }

    //list all by
}
