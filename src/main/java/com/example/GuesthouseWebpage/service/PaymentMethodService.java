package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.PaymentMethod;
import com.example.GuesthouseWebpage.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    //method to create paymentMethod
    public void createPaymentMethod(PaymentMethod paymentMethod){
        paymentMethod.setActive(true);
        paymentMethodRepository.save(paymentMethod);
    }
    //method to find paymentMethod by id
    public Optional<PaymentMethod> findPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id);
    }

    //method to update paymentMethod by id
    public void updatePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodRepository.saveAndFlush(paymentMethod);
    }

    //method to "delete" paymentMethod by id - set active false so no one can see the extra
    public void deletePaymentMethodById(Long id) {
        findPaymentMethodById(id).ifPresent(paymentMethod -> {
            paymentMethod.setActive(false);
            updatePaymentMethod(paymentMethod);
        });
    }

    //method to restore paymentMethod
    public void restorePaymentMethodById(Long id){
        findPaymentMethodById(id).ifPresent(paymentMethod -> {
            paymentMethod.setActive(true);
            updatePaymentMethod(paymentMethod);
        });
    }

    //method to really fully delete paymentMethod by id
    public void fullDeletePaymentMethodById(Long id) {
        paymentMethodRepository.deleteById(id);
    }

    //list all paymentMethods
    public List<PaymentMethod> getAllPaymentMethods(){
        return paymentMethodRepository.findAll();
    }

    //list all active paymentMethods
    public List<PaymentMethod> getActivePaymentMethods(){
        return getAllPaymentMethods().stream()
                .filter(PaymentMethod::isActive)
                .collect(Collectors.toList());
    }
}
