package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.GuestHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestHouseRepository extends JpaRepository<GuestHouse, Long> {

}
