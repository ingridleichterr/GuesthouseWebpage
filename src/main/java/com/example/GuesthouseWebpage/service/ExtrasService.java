package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Extras;
import com.example.GuesthouseWebpage.repository.ExtrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExtrasService {

    @Autowired
    private ExtrasRepository extrasRepository;

    //method to create extra
    public void createExtra(Extras extra){
        extrasRepository.save(extra);
    }

    //method to update extra by extra id

    //method to delete extra by extra id

}
