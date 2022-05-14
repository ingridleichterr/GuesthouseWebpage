package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
