package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Extras;
import com.example.GuesthouseWebpage.model.Meal;
import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class ExtrasService {
    private ExtrasService extrasService;
    private EntityManager em;
    public ExtrasService() {
        em = DBUtil.getEntityManager();
    }

    @Autowired
    public ExtrasService(ExtrasService extrasService) {
        this.extrasService = extrasService;
    }


    //method save extra
    public void saveExtra(Extras extras){
        try {
            em.getTransaction().begin();
            this.em.persist(extras);
            em.getTransaction().commit();

        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    //method to find extras By extrasId
    public Extras findExtraById (int extrasId){

        return em.find(Extras.class, extrasId);
    }
    //method to update extras price by extra id
    public void updateExtrasPrice (double newPrice, int extraId){
        em.getTransaction().begin();
        String sql = "UPDATE Extras SET price = :nPrice" +
                " WHERE extraId = :id";

        int result = this.em.createQuery(sql)
                .setParameter("nPrice", newPrice)
                .setParameter("id", extraId)
                .executeUpdate();
        em.getTransaction().commit();

    }
}
