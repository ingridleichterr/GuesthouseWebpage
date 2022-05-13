package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Booking;
import com.example.GuesthouseWebpage.model.CountBooking;
import com.example.GuesthouseWebpage.model.ShowBookingsOfARoom;
import com.example.GuesthouseWebpage.model.ShowBookingsOnADate;
import com.example.GuesthouseWebpage.repository.BookingRepository;
import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class BookingService{
    private BookingRepository bookingRepository;
    private static EntityManager em;
    public BookingService() {
        em = DBUtil.getEntityManager();
    }

    @Autowired
    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository=bookingRepository;
    }

    //method to save
    public static void saveBooking(Booking booking){
        try {
            em.getTransaction().begin();
            em.persist(booking);
            em.getTransaction().commit();

        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    //method count all bookings by date
    public static List<CountBooking> bookingsByDate(){
        String sql = "SELECT new com.example.GuesthouseWebpage.model.CountBooking(arrivalDate, " +
                " COUNT(*))" +
                " FROM Booking" +
                " GROUP BY arrivalDate";
        return em.createQuery(sql, CountBooking.class).getResultList();

    }

    //list all bookings in one date you receive from user
    public static List<ShowBookingsOnADate> bookingsOnADate(String enteredDate){
        try {
            String sql = "SELECT new com.example.GuesthouseWebpage.model.ShowBookingsOnADate(b.bookingId, b.customer.name," +
                    " b.room.name, b.meal.name)" +
                    " FROM Booking b" +
                    " WHERE b.arrivalDate= :enteredDate";

            return em.createQuery(sql, ShowBookingsOnADate.class)
                    .setParameter("enteredDate", enteredDate)
                    .getResultList();
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //list all bookings for one room
    public static List<ShowBookingsOfARoom> bookingsOfARoom(int enteredRoomId){
        try {
            String sql = "SELECT new com.example.GuesthouseWebpage.model.ShowBookingsOfARoom(b.room.roomId, b.room.name," +
                    " b.arrivalDate, b.bookingId, b.customer.name)" +
                    " FROM Booking b" +
                    " WHERE b.room.roomId= :enteredRoomId" +
                    " ORDER BY b.arrivalDate ASC";

            return em.createQuery(sql, ShowBookingsOfARoom.class)
                    .setParameter("enteredRoomId", enteredRoomId)
                    .getResultList();
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
