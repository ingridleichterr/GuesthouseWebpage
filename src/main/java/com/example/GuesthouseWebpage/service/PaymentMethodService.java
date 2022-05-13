package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class PaymentMethodService {
    private PaymentMethodService paymentMethodService;
    private EntityManager em;
    public PaymentMethodService() {
        em = DBUtil.getEntityManager();
    }


    @Autowired
    public PaymentMethodService(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }
}
