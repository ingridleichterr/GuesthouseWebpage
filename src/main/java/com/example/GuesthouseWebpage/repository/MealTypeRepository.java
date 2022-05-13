package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.MealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealTypeRepository extends JpaRepository<MealType, Integer> {

}
