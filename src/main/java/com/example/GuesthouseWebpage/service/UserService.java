package com.example.GuesthouseWebpage.service;


import com.example.GuesthouseWebpage.exceptions.UserNotFoundException;

import com.example.GuesthouseWebpage.model.Authority;
import com.example.GuesthouseWebpage.model.User;
import com.example.GuesthouseWebpage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.GuesthouseWebpage.utils.Constants.Security.AUTHORITY_USER;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityService authorityService;

    //method to create user
    public void createUser(User user){
        user.setActive(true);
        user.setRegistrationDate(LocalDate.now());
        Optional<Authority> optionalAuthority = authorityService.findAuthorityByName(AUTHORITY_USER);
        user.setAuthority(optionalAuthority.get());
        userRepository.save(user);
    }

    //method to find user by id
    public User findUserById(Long id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException(id);
        } else {
            return optionalUser.get();
        }
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




}
