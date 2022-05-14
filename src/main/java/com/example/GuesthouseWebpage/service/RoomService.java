package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.MealType;
import com.example.GuesthouseWebpage.model.Room;
import com.example.GuesthouseWebpage.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    //method to create Room
    public void createRoom(Room room){
        room.setActive(true);
        roomRepository.save(room);
    }
    //method to find room by id
    public Optional<Room> findRoomById(Long id) {
        return roomRepository.findById(id);
    }

    //method to update room by id
    public void updateRoom(Room room) {
        roomRepository.saveAndFlush(room);
    }

    //method to "delete" room by id - set active false so no one can see the extra
    public void deleteRoomById(Long id) {
        findRoomById(id).ifPresent(room -> {
            room.setActive(false);
            updateRoom(room);
        });
    }

    //method to restore room
    public void restoreRoomById(Long id){
        findRoomById(id).ifPresent(room -> {
            room.setActive(true);
            updateRoom(room);
        });
    }

    //method to really fully delete room by id
    public void fullDeleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    //list all rooms
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    //list all active rooms
    public List<Room> getActiveRooms(){
        return getAllRooms().stream()
                .filter(Room::isActive)
                .collect(Collectors.toList());
    }


}
