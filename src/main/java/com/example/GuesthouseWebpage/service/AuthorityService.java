package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Authority;
import com.example.GuesthouseWebpage.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;


    public void createAuthority(Authority authority) {

        authorityRepository.save(authority);
    }


    public Optional<Authority> findAuthorityByName(String name) {

        return authorityRepository.findByName(name);
    }


    public List<Authority> findAllAuthorities() {

        return authorityRepository.findAll();
    }
}
