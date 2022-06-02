package com.example.GuesthouseWebpage.controller;
import com.example.GuesthouseWebpage.exceptions.RoomNotFoundException;
import com.example.GuesthouseWebpage.exceptions.UserNotFoundException;
import com.example.GuesthouseWebpage.model.Room;
import com.example.GuesthouseWebpage.model.User;
import com.example.GuesthouseWebpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//controller to handle user requests
@RestController
@RequestMapping("/signup")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User>updateUser(@RequestBody User user) {
        userService.updateUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());

        return new ResponseEntity<>(user, headers, HttpStatus.OK);
    }


    @GetMapping("/full-delete/{id}")
    public ResponseEntity<?> fullDeleteUser(@PathVariable Long id) {
        userService.fullDeleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try{
            User user = userService.findUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException userNotFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData) throws UserNotFoundException {
            User user = userService.findUserById(userData.getId());
            if (user.getPassword().equals(userData.getPassword())){
                return ResponseEntity.ok(user);
            }else {
                return (ResponseEntity<?>) ResponseEntity.internalServerError();
            }
    }



}
