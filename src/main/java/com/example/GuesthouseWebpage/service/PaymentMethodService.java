package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.PaymentMethod;
import com.example.GuesthouseWebpage.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    //method to create paymentMethod
    public void createPaymentMethod(PaymentMethod paymentMethod){
        paymentMethodRepository.save(paymentMethod);
    }

    //method to update paymentMethod by paymentMethod id

    //method to delete paymentMethod by paymentMethod id

}
