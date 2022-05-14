package com.example.GuesthouseWebpage.controller;

import com.example.GuesthouseWebpage.model.Booking;
import com.example.GuesthouseWebpage.model.Extras;
import com.example.GuesthouseWebpage.service.ExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//Controller to handle extras requests
@RestController
@RequestMapping("/extras")
public class ExtrasController {

    @Autowired
    private ExtrasService extrasService;

    @PostMapping
    public ResponseEntity<?> createExtra(@RequestBody Extras extra){
        extrasService.createExtra(extra);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Extras>updateExtra(@RequestBody Extras extra) {
        extrasService.updateExtra(extra);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());

        return new ResponseEntity<>(extra, headers, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteExtra(@PathVariable Long id) {
        extrasService.deleteExtraById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<?> fullDeleteExtra(@PathVariable Long id) {
        extrasService.fullDeleteExtraById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreExtra(@PathVariable Long id) {
        extrasService.restoreExtraById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<Extras> getAllExtras(){
        return extrasService.getAllExtras();
    }

    @GetMapping
    public List<Extras> getAllActiveExtras(){
        return extrasService.getActiveExtras();
    }


}
