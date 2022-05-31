package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.User;
import com.example.GuesthouseWebpage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //method to create user
    public void createUser(User user){
        user.setActive(true);
        userRepository.save(user);
    }
    //method to find user by id
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }


    //method to update user by id
    public void updateUser(User user) {
        userRepository.saveAndFlush(user);
    }


    //method to really fully delete user by id
    public void fullDeleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    //list all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //list all active users
    public List<User> getActiveUsers(){
        return getAllUsers().stream()
                .filter(User::isActive)
                .collect(Collectors.toList());
    }


}
