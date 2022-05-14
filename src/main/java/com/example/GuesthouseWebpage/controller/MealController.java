package com.example.GuesthouseWebpage.controller;

import com.example.GuesthouseWebpage.service.MealService;
import com.example.GuesthouseWebpage.service.MealTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controller to handle meal and mealtype requests
@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private MealTypeService mealTypeService;



}
