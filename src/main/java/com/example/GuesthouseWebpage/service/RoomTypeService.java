package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Room;
import com.example.GuesthouseWebpage.model.RoomType;
import com.example.GuesthouseWebpage.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    //method to create RoomType
    public void createRoomType(RoomType roomType){
        roomType.setActive(true);
        roomTypeRepository.save(roomType);
    }
    //method to find roomType by id
    public Optional<RoomType> findRoomTypeById(Long id) {
        return roomTypeRepository.findById(id);
    }

    //method to update roomType by id
    public void updateRoomType(RoomType roomType) {
        roomTypeRepository.saveAndFlush(roomType);
    }

    //method to "delete" roomType by id - set active false so no one can see the extra
    public void deleteRoomTypeById(Long id) {
        findRoomTypeById(id).ifPresent(roomType -> {
            roomType.setActive(false);
            updateRoomType(roomType);
        });
    }

    //method to restore roomType
    public void restoreRoomTypeById(Long id){
        findRoomTypeById(id).ifPresent(roomType -> {
            roomType.setActive(true);
            updateRoomType(roomType);
        });
    }

    //method to really fully delete roomType by id
    public void fullDeleteRoomTypeById(Long id) {
        roomTypeRepository.deleteById(id);
    }

    //list all roomsType
    public List<RoomType> getAllRoomTypes(){
        return roomTypeRepository.findAll();
    }

    //list all active roomTypes
    public List<RoomType> getActiveRoomTypes(){
        return getAllRoomTypes().stream()
                .filter(RoomType::isActive)
                .collect(Collectors.toList());
    }

}
