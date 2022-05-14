package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.repository.BookingPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingPaymentService {

    @Autowired
    private BookingPaymentRepository bookingPaymentRepository;

}
