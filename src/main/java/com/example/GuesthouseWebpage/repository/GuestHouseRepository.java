package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.GuestHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestHouseRepository extends JpaRepository<GuestHouse, Integer> {
    List<GuestHouse> guesthouseInfo();


}
