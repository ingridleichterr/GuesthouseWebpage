package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.GuestHouse;
import com.example.GuesthouseWebpage.repository.GuestHouseRepository;
import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class GuestHouseService {
    private GuestHouseRepository guestHouseRepository;
    private static EntityManager em;
    public GuestHouseService() {
        em = DBUtil.getEntityManager();
    }


    @Autowired
    public GuestHouseService(GuestHouseRepository guestHouseRepository) {
        this.guestHouseRepository = guestHouseRepository;
    }

    public static List<GuestHouse> showGuestHouseInfo() {
        String sql = "SELECT new com.example.GuesthouseWebpage.model.GuestHouse(address, name, phoneNumber)" +
                " FROM GuestHouse";

        return em.createQuery(sql, GuestHouse.class).getResultList();
    }
}
