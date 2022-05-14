package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.RoomType;
import com.example.GuesthouseWebpage.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    //method to create roomType
    public void createRoomType(RoomType roomType){
        roomTypeRepository.save(roomType);
    }

    //method to update roomType by roomType id

    //method to delete roomType by eroomTypextra id

}
