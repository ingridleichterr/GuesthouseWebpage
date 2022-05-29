package com.example.GuesthouseWebpage.controller;

import com.example.GuesthouseWebpage.exceptions.ExtraNotFoundException;
import com.example.GuesthouseWebpage.exceptions.RoomNotFoundException;
import com.example.GuesthouseWebpage.model.Booking;
import com.example.GuesthouseWebpage.model.Extras;
import com.example.GuesthouseWebpage.model.Room;
import com.example.GuesthouseWebpage.service.ExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//Controller to handle extras requests
@RestController
@RequestMapping("/extras")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ExtrasController {

    @Autowired
    private ExtrasService extrasService;

    @PostMapping
    public ResponseEntity<?> createExtra(@RequestBody Extras extras){
        extrasService.createExtra(extras);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Extras>updateExtra(@RequestBody Extras extras) {
        extrasService.updateExtra(extras);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());

        return new ResponseEntity<>(extras, headers, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteExtra(@PathVariable Long id) {
        try {
            extrasService.deleteExtraById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(ExtraNotFoundException extraNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<?> fullDeleteExtra(@PathVariable Long id) {
        extrasService.fullDeleteExtraById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreExtra(@PathVariable Long id) throws ExtraNotFoundException {
        try {
            extrasService.restoreExtraById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ExtraNotFoundException extraNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Extras> getAllExtras(){
        return extrasService.getAllExtras();
    }

    @GetMapping("/active")
    public List<Extras> getAllActiveExtras(){
        return extrasService.getActiveExtras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExtraById(@PathVariable Long id) {
        try{
            Extras extras = extrasService.findExtraById(id);
            return new ResponseEntity<>(extras, HttpStatus.OK);
        } catch (ExtraNotFoundException extraNotFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }


}
