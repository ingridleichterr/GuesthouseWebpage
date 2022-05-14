package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.MealType;
import com.example.GuesthouseWebpage.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MealTypeService {

    @Autowired
    private MealTypeRepository mealTypeRepository;

    //method to create mealType
    public void createMealType(MealType mealType){
        mealType.setActive(true);
        mealTypeRepository.save(mealType);
    }
    //method to find mealType by id
    public Optional<MealType> findMealTypeById(Long id) {
        return mealTypeRepository.findById(id);
    }

    //method to update mealType by id
    public void updateMealType(MealType mealType) {
        mealTypeRepository.saveAndFlush(mealType);
    }

    //method to "delete" mealType by id - set active false so no one can see the extra
    public void deleteMealTypeById(Long id) {
        findMealTypeById(id).ifPresent(mealType -> {
            mealType.setActive(false);
            updateMealType(mealType);
        });
    }

    //method to restore mealType
    public void restoreMealTypeById(Long id){
        findMealTypeById(id).ifPresent(mealType -> {
            mealType.setActive(true);
            updateMealType(mealType);
        });
    }

    //method to really fully delete mealType by id
    public void fullDeleteMealTypeById(Long id) {
        mealTypeRepository.deleteById(id);
    }

    //list all mealTypes
    public List<MealType> getAllMealTypes(){
        return mealTypeRepository.findAll();
    }

    //list all active mealTypes
    public List<MealType> getActiveMealTypes(){
        return getAllMealTypes().stream()
                .filter(MealType::isActive)
                .collect(Collectors.toList());
    }

}
