package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

}
