package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.repository.GuestHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class GuestHouseService {

    @Autowired
    private GuestHouseRepository guestHouseRepository;

}
