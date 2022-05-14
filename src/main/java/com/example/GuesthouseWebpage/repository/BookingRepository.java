package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
