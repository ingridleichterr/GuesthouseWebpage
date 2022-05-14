package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Room;
import com.example.GuesthouseWebpage.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    //method to create room
    public void createRoom(Room room){
        roomRepository.save(room);
    }

    //method to update room by room id

    //method to delete room by room id


}
