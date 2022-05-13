package com.example.GuesthouseWebpage.repository;

import com.example.GuesthouseWebpage.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {


}
