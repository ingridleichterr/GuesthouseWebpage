package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.User;
import com.example.GuesthouseWebpage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //method to create user
    public void createUser(User user){
        userRepository.save(user);
    }

    //method to update user by user id

    //method to delete user by user id

    //method count total number of users

    //method list all users


}
