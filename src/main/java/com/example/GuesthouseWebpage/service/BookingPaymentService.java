package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.repository.BookingPaymentRepository;
import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class BookingPaymentService {
    private BookingPaymentRepository bookingPaymentRepository;
    private EntityManager em;

    public BookingPaymentService() {
        em = DBUtil.getEntityManager();
    }


    @Autowired
    public BookingPaymentService(BookingPaymentRepository bookingPaymentRepository) {
        this.bookingPaymentRepository = bookingPaymentRepository;
    }
}
