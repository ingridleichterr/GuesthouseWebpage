package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.exceptions.MealNotFoundException;
import com.example.GuesthouseWebpage.model.Meal;
import com.example.GuesthouseWebpage.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    //method to create meal
    public void createMeal(Meal meal){
        meal.setActive(true);
        mealRepository.save(meal);
    }
    //method to find meals by id
    public Meal findMealById(Long id) throws MealNotFoundException {
        Optional<Meal> optionalMeal = mealRepository.findById(id);

        if(optionalMeal.isEmpty()) {
            throw new MealNotFoundException(id);
        } else {
            return optionalMeal.get();
        }
    }

    //method to update meal by id
    public void updateMeal(Meal meal) {
        mealRepository.saveAndFlush(meal);
    }

    //method to "delete" meal by id - set active false so no one can see the extra
    public void deleteMealById(Long id)throws MealNotFoundException {
        Meal meal = findMealById(id);
        meal.setActive(false);
        updateMeal(meal);
    }

    //method to restore meal
    public void restoreMealById(Long id) throws MealNotFoundException {
        Meal meal = findMealById(id);
        meal.setActive(true);
        updateMeal(meal);
    }

    //method to really fully delete meal by id
    public void fullDeleteMealById(Long id) {
        mealRepository.deleteById(id);
    }

    //list all meals
    public List<Meal> getAllMeals(){
        return mealRepository.findAll();
    }

    //list all active meals
    public List<Meal> getActiveMeals(){
        return getAllMeals().stream()
                .filter(Meal::isActive)
                .collect(Collectors.toList());
    }

}
