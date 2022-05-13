package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.repository.MealTypeRepository;
import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class MealTypeService {
    private MealTypeRepository mealTypeRepository;
    private EntityManager em;

    public MealTypeService() {
        em = DBUtil.getEntityManager();
    }


    @Autowired
    public MealTypeService(MealTypeRepository mealTypeRepository) {
        this.mealTypeRepository = mealTypeRepository;
    }
}
