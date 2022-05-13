package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.BookingPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingPaymentRepository extends JpaRepository<BookingPayment, Integer> {
}
