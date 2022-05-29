package com.example.GuesthouseWebpage.controller;

import com.example.GuesthouseWebpage.exceptions.RoomNotFoundException;
import com.example.GuesthouseWebpage.model.Room;
import com.example.GuesthouseWebpage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//Controller to handle room requests
@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody Room room){
        roomService.createRoom(room);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Room>updateRoom(@RequestBody Room room) {
        roomService.updateRoom(room);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());

        return new ResponseEntity<>(room, headers, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
        try {
            roomService.deleteRoomById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(RoomNotFoundException roomNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<?> fullDeleteRoom(@PathVariable Long id) {
        roomService.fullDeleteRoomById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreRoom(@PathVariable Long id) throws RoomNotFoundException {
        try {
            roomService.restoreRoomById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RoomNotFoundException roomNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/active")
    public List<Room> getAllActiveRooms(){
        return roomService.getActiveRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id) {
        try{
            Room room = roomService.findRoomById(id);
            return new ResponseEntity<>(room, HttpStatus.OK);
        } catch (RoomNotFoundException roomNotFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }


}