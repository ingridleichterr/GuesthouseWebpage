package com.example.GuesthouseWebpage.controller;

import com.example.GuesthouseWebpage.model.Meal;
import com.example.GuesthouseWebpage.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//controller to handle meal requests
@RestController
@RequestMapping("/meals")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MealController {

    @Autowired
    private MealService mealService;


    @PostMapping
    public ResponseEntity<?> createMeal(@RequestBody Meal meal){
        mealService.createMeal(meal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal>updateMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setDate(new Date().toInstant());

        return new ResponseEntity<>(meal, headers, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteMeal(@PathVariable Long id) {
        mealService.deleteMealById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/full-delete/{id}")
    public ResponseEntity<?> fullDeleteMeal(@PathVariable Long id) {
        mealService.fullDeleteMealById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/restore/{id}")
    public ResponseEntity<?> restoreMeal(@PathVariable Long id) {
        mealService.restoreMealById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<Meal> getAllMeals(){
        return mealService.getAllMeals();
    }

    @GetMapping("/active")
    public List<Meal> getAllActiveMeals(){
        return mealService.getActiveMeals();
    }



}
