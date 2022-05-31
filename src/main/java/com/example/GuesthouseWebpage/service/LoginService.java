package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.exceptions.InvalidLoginException;
import com.example.GuesthouseWebpage.model.Login;
import com.example.GuesthouseWebpage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginService {
    @Autowired
    private UserService userService;


    public void validateLogin(Login login) throws InvalidLoginException {
        Optional<User> userOptional = userService.findByEmailAndPassword(login.getEmail(), login.getPassword());

        if (userOptional.isEmpty()) {
            throw new InvalidLoginException(login.getEmail());
        }
    }
}
