package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Meal;
import com.example.GuesthouseWebpage.repository.MealRepository;
import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class MealService {
    private MealRepository mealRepository;
    private EntityManager em;
    public MealService() {
        em = DBUtil.getEntityManager();
    }

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    //method save meal
    public void saveMeal(Meal meal){
        try {
            em.getTransaction().begin();
            this.em.persist(meal);
            em.getTransaction().commit();

        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    //method to find meal By mealId
    public Meal findMealById (int mealId){

        return em.find(Meal.class, mealId);
    }

    //method to update meal price by meal id
    public void updateMealPrice (double newPrice, int mealId){
        em.getTransaction().begin();
        String sql = "UPDATE Meal SET price = :nPrice" +
                " WHERE mealId = :id";

        int result = this.em.createQuery(sql)
                .setParameter("nPrice", newPrice)
                .setParameter("id", mealId)
                .executeUpdate();
        em.getTransaction().commit();

    }

}
