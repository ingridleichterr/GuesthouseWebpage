package com.example.GuesthouseWebpage.controller;

import com.example.GuesthouseWebpage.exceptions.InvalidLoginException;
import com.example.GuesthouseWebpage.model.Login;
import com.example.GuesthouseWebpage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
@CrossOrigin(origins = {"http://localhost:4200"})
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> postLogin(@RequestBody Login login) throws InvalidLoginException {
        loginService.validateLogin(login);
        return new ResponseEntity<>(login, HttpStatus.ACCEPTED);
    }
}
