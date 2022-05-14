package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Meal;
import com.example.GuesthouseWebpage.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    //method to create meal
    public void createMeal(Meal meal){
        mealRepository.save(meal);
    }

    //method to update meal price by meal id

    //method to delete meal by meal id

}
