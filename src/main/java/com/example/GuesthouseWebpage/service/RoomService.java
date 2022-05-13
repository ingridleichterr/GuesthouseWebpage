package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Room;
import com.example.GuesthouseWebpage.repository.RoomRepository;
import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class RoomService {
    private RoomRepository roomRepository;
    private EntityManager em;
    public RoomService() {
        em = DBUtil.getEntityManager();
    }

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    //method save new room
    public void saveRoom(Room room){
        try {
            em.getTransaction().begin();
            this.em.persist(room);
            em.getTransaction().commit();

        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

}
