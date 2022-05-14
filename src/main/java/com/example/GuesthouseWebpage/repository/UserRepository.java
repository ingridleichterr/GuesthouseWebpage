package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
