package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.MealType;
import com.example.GuesthouseWebpage.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MealTypeService {

    @Autowired
    private MealTypeRepository mealTypeRepository;

    //method to create mealType
    public void createMealType(MealType mealType){
        mealTypeRepository.save(mealType);
    }

    //method to update mealType by mealType id

    //method to delete mealType by mealType id



}
